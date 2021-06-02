package oficina;
import javax.swing.JOptionPane;

public class Main {
	
	public static void lerAtributos() {
		float peso = 0;
		int ano = 0, capacTaque = 0;
		
		String[] locomocoes = {"Autom�vel", "Barco", "Avi�o", "sair"};
		
		int loc = JOptionPane.showOptionDialog(null, "Em qual categoria o seu ve�culo melhor se encaixa?", "Locomo��es", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, locomocoes, locomocoes[0]);
		if (loc == 3) {
			System.exit(0);
		}
		String marca = JOptionPane.showInputDialog("Qual � a marca do seu ve�culo?");
		String modelo = JOptionPane.showInputDialog("Qual � o modelo do seu ve�culo?");
		String combustivel = JOptionPane.showInputDialog("Quais tipos de combustivel seu ve�culo aceita?");
		
		while (peso == 0) {
			try {
	            peso = Float.parseFloat(JOptionPane.showInputDialog("Digite, em kg, o peso do seu ve�culo."));
			} catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Houve algum erro de digita��o. Tente novamente.");
	            peso = 0;
			}
		}
		
		while (ano == 0) {
			try {
	            ano = Integer.parseInt(JOptionPane.showInputDialog("Qual foi o ano de fabrica��o do seu ve�culo?"));
			} catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Houve algum erro de digita��o. Tente novamente.");
	            ano = 0;
			}
		}
		
		while (capacTaque == 0) {
			try {
				capacTaque = Integer.parseInt(JOptionPane.showInputDialog("Digite, em litros, a capacidade total do tanque de seu ve�culo."));
			} catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Houve algum erro de digita��o. Tente novamente.");
	            capacTaque = 0;
			}
		}
		
		String[] atributos = {marca, modelo, combustivel, Float.toString(peso), Integer.toString(ano), Integer.toString(capacTaque)};
		
		criarVeiculo(atributos, locomocoes[loc]);
	}
	
	public static void criarVeiculo(String[] atributos, String locomocao) {
		if(locomocao == "Autom�vel") {
			Automovel aut = new Automovel(atributos[0], atributos[1], atributos[2], Float.parseFloat(atributos[3]), Integer.parseInt(atributos[4]), Integer.parseInt(atributos[5]));
			menu(aut);
		}
		
		else if(locomocao == "Avi�o") {
			Aviao avi = new Aviao(atributos[0], atributos[1], atributos[2], Float.parseFloat(atributos[3]), Integer.parseInt(atributos[4]), Integer.parseInt(atributos[5]));
			menu(avi);
		}
		
		else if(locomocao == "Barco") {
			Barco bar = new Barco(atributos[0], atributos[1], atributos[2], Float.parseFloat(atributos[3]), Integer.parseInt(atributos[4]), Integer.parseInt(atributos[5]));
			menu(bar);
		}
	}
	
	public static void menu(MeioDeTransporte obj) {
		String[] opcs = {"Ligar/Desligar", "Abastecer", "Viajar", "Finalizar viagem", "Mostrar informac�es", "Inicio", "sair"};
		int loc = JOptionPane.showOptionDialog(null, "Escolha a a��o desejada:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcs, opcs[0]);
		
		switch (loc) {
		case 0:
			obj.ligarDesligar();
			menu(obj);
		break;
		
		case 1:
			if(obj.ligado) {
				JOptionPane.showMessageDialog(null, "Desligue o seu ve�culo para que ele possa ser abastecido!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(obj.tanque == obj.capacidadeTanque || obj.capacidadeTanque - obj.tanque < 10) { 
				JOptionPane.showMessageDialog(null, "O tanque do seu ve�culo est� cheio!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				obj.abastecer();
			}
			
			menu(obj);
		break;
		
		case 2:
			if(obj.estado) {
				JOptionPane.showMessageDialog(null, "O ve�culo j� est� em uma viagem!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(!obj.ligado) {
				JOptionPane.showMessageDialog(null, "O ve�culo n�o pode se mover enquanto estiver desligado!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			
			else if(obj.tanque < 10) {
				JOptionPane.showMessageDialog(null, "Combust�vel insuficiente para uma viagem!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				obj.viajar();
			}
			
			menu(obj);
		break;
		
		case 3:
			if(!obj.estado) {
				JOptionPane.showMessageDialog(null, "Seu ve�culo n�o est� em uma viagem!", "Ops", JOptionPane.ERROR_MESSAGE);
			}
			else {
				obj.pararViajem();
			}
			menu(obj);
		break;
		
		case 4:
			JOptionPane.showMessageDialog(null, obj.InformarAtributos(), "Informa��es " + obj.locomocao, JOptionPane.INFORMATION_MESSAGE);
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
		JOptionPane.showMessageDialog(null,"Ol�, seja bem vindo(a)!", "Boas vindas", JOptionPane.INFORMATION_MESSAGE);
		lerAtributos();
		}
	}