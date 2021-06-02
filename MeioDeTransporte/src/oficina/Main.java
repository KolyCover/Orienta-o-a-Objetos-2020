package oficina;
import javax.swing.JOptionPane;

public class Main {
	
	public static void lerAtributos() {
		float peso = 0;
		int ano = 0, capacTaque = 0;
		
		String[] locomocoes = {"Automóvel", "Barco", "Avião", "sair"};
		
		int loc = JOptionPane.showOptionDialog(null, "Em qual categoria o seu veículo melhor se encaixa?", "Locomoções", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, locomocoes, locomocoes[0]);
		if (loc == 3) {
			System.exit(0);
		}
		String marca = JOptionPane.showInputDialog("Qual é a marca do seu veículo?");
		String modelo = JOptionPane.showInputDialog("Qual é o modelo do seu veículo?");
		String combustivel = JOptionPane.showInputDialog("Quais tipos de combustivel seu veículo aceita?");
		
		while (peso == 0) {
			try {
	            peso = Float.parseFloat(JOptionPane.showInputDialog("Digite, em kg, o peso do seu veículo."));
			} catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Houve algum erro de digitação. Tente novamente.");
	            peso = 0;
			}
		}
		
		while (ano == 0) {
			try {
	            ano = Integer.parseInt(JOptionPane.showInputDialog("Qual foi o ano de fabricação do seu veículo?"));
			} catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Houve algum erro de digitação. Tente novamente.");
	            ano = 0;
			}
		}
		
		while (capacTaque == 0) {
			try {
				capacTaque = Integer.parseInt(JOptionPane.showInputDialog("Digite, em litros, a capacidade total do tanque de seu veículo."));
			} catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Houve algum erro de digitação. Tente novamente.");
	            capacTaque = 0;
			}
		}
		
		String[] atributos = {marca, modelo, combustivel, Float.toString(peso), Integer.toString(ano), Integer.toString(capacTaque)};
		
		criarVeiculo(atributos, locomocoes[loc]);
	}
	
	public static void criarVeiculo(String[] atributos, String locomocao) {
		if(locomocao == "Automóvel") {
			Automovel aut = new Automovel(atributos[0], atributos[1], atributos[2], Float.parseFloat(atributos[3]), Integer.parseInt(atributos[4]), Integer.parseInt(atributos[5]));
			menu(aut);
		}
		
		else if(locomocao == "Avião") {
			Aviao avi = new Aviao(atributos[0], atributos[1], atributos[2], Float.parseFloat(atributos[3]), Integer.parseInt(atributos[4]), Integer.parseInt(atributos[5]));
			menu(avi);
		}
		
		else if(locomocao == "Barco") {
			Barco bar = new Barco(atributos[0], atributos[1], atributos[2], Float.parseFloat(atributos[3]), Integer.parseInt(atributos[4]), Integer.parseInt(atributos[5]));
			menu(bar);
		}
	}
	
	public static void menu(MeioDeTransporte obj) {
		String[] opcs = {"Ligar/Desligar", "Abastecer", "Viajar", "Finalizar viagem", "Mostrar informacões", "Inicio", "sair"};
		int loc = JOptionPane.showOptionDialog(null, "Escolha a ação desejada:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcs, opcs[0]);
		
		switch (loc) {
		case 0:
			obj.ligarDesligar();
			menu(obj);
		break;
		
		case 1:
			if(obj.ligado) {
				JOptionPane.showMessageDialog(null, "Desligue o seu veículo para que ele possa ser abastecido!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(obj.tanque == obj.capacidadeTanque || obj.capacidadeTanque - obj.tanque < 10) { 
				JOptionPane.showMessageDialog(null, "O tanque do seu veículo está cheio!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				obj.abastecer();
			}
			
			menu(obj);
		break;
		
		case 2:
			if(obj.estado) {
				JOptionPane.showMessageDialog(null, "O veículo já está em uma viagem!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(!obj.ligado) {
				JOptionPane.showMessageDialog(null, "O veículo não pode se mover enquanto estiver desligado!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(obj.tanque < 10) {
				JOptionPane.showMessageDialog(null, "Combustível insuficiente para uma viagem!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				obj.viajar();
			}
			
			menu(obj);
		break;
		
		case 3:
			if(!obj.estado) {
				JOptionPane.showMessageDialog(null, "Seu veículo não está em uma viagem!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			else {
				obj.pararViajem();
			}
			menu(obj);
		break;
		
		case 4:
			JOptionPane.showMessageDialog(null, obj.InformarAtributos(), "Informações " + obj.locomocao, JOptionPane.INFORMATION_MESSAGE);
			menu(obj);
		break;
		
		case 5:
			lerAtributos();
		break;
		
		case 6:
			System.exit(0);
		break;
		}
	}

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,"Olá, seja bem vindo(a)!", "Boas vindas", JOptionPane.INFORMATION_MESSAGE);
		lerAtributos();
		}
	}