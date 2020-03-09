package Automoveis;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Automovel {
	String tipo, marca, modelo, cor, combustivel;
	int ano;
	boolean status, manutencao, nivelCombus;
	static ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
	
	public static void informarOpc () {
		int opc;
		String[] opcs = {"Sair", "Cadastro", "Ações", "Automóveis cadastrados"};
		
		do {
			opc = JOptionPane.showOptionDialog(null, "Selecione a opção desejada.", "Automóveis", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcs, opcs[0]);
			
			verificarOpc(opc);
			
		} while (opc != 0);
	}
	
	public static void verificarOpc (int opc) {
		
		switch (opc) {
		
		case 0:
			System.exit(0);
		break;
		
		case 1:
			criarObj();
		break;
		
		case 2:
			informarMet(escolherObj());
		break;
		
		case 3:
			imprimirAtributos();
		break;
		}
	}

	public static void criarObj () {
		Automovel aut = new Automovel();
		aut.coletarAtributos();
		aut.armazenarObj();
	}
	
	public void coletarAtributos() {
		this.tipo = JOptionPane.showInputDialog("Qual é o tipo do seu automóvel? Exemplos: carro, moto...");
		this.marca = JOptionPane.showInputDialog("Qual é a marca do seu automóvel?");
		this.modelo = JOptionPane.showInputDialog("Qual é o modelo do seu automóvel?");
		this.cor = JOptionPane.showInputDialog("Qual é a cor do seu automóvel?");
		this.combustivel = JOptionPane.showInputDialog("Qual é o tipo do combustível do seu automóvel?");
		this.ano = Integer.parseInt(JOptionPane.showInputDialog("Qual é o ano de fabricação do seu automóvel?"));
	}
	
	public void armazenarObj () {
		automoveis.add(this);
	}
	
	public static void informarMet (Automovel aut) {
		int opc;
		String[] options = {"Menu inicial", "Ligar/desligar", "Abastecer", "Rodar", "Colocar/tirar da manutenção"};
		
		do {
			opc = JOptionPane.showOptionDialog(null, "O que você deseja fazer?", "Métodos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			
			aut.verificarMet(opc, aut);
			
		} while(opc != 0);
		
		
	}
	
	public static Automovel escolherObj () {
		ArrayList <String> opcs = new ArrayList<>();
		
		for (Automovel aut : automoveis) {
			opcs.add(aut.marca + " " + aut.modelo);
		}
		
		int opc = JOptionPane.showOptionDialog(null, "Qual automóvel você deseja manipular?", "Automóveis", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcs.toArray(), opcs.toArray()[0]);
		
		return automoveis.get(opc);
	}
	
	public void verificarMet (int opc, Automovel aut) {
		
		switch(opc) {
		
		case 0:
			informarOpc();
		break;
		
		case 1:
			aut.OnOff();
		break;
		
		case 2:
			if (!status )
				aut.abastecer();
			
			else
				JOptionPane.showMessageDialog(null, "Seu automóvel está ligado. Ele só pode ser abastecido quando estiver desligado!", "Ops!", JOptionPane.ERROR_MESSAGE);
			
		break;
		
		case 3:
			if (status == true && manutencao == false && nivelCombus == true) 
				aut.rodar();
			
			else {
				if (!status)
					JOptionPane.showMessageDialog(null, "Seu automóvel está desligado. Ligue-o para para fazê-lo rodar!", "Ops!", JOptionPane.ERROR_MESSAGE);
				
				if (manutencao)
					JOptionPane.showMessageDialog(null, "Seu automóvel está em manutenção. Ele só poder rodar quando estiver consertado!", "Ops!", JOptionPane.ERROR_MESSAGE);
				
				if (!nivelCombus)
					JOptionPane.showMessageDialog(null, "Seu automóvel está sem combustível. Reabasteca-o para fazê-lo rodar!", "Ops!", JOptionPane.ERROR_MESSAGE);
			}
		break;
		
		case 4:
			aut.manutencao();
		break;
	
		}
	}
	
	public boolean verificaStt ( ) {
		return status;
	}
	
	public void OnOff () {
		if (status) {
			status = false;
			JOptionPane.showMessageDialog(null, "Seu automóvel foi desligado!");
			
		}
		
		else {
			status = true;
			JOptionPane.showMessageDialog(null, "Seu automóvel foi ligado!");
		}
	}
	
	public void abastecer () {
		nivelCombus = true;
		JOptionPane.showMessageDialog(null, "Carro abastecido!");
	}
	
	public void rodar () {
		JOptionPane.showMessageDialog(null, "Seu carro está rodando!");
		nivelCombus = false;
	}
	
	public void manutencao () {
		if (manutencao) {
			manutencao = false;
			JOptionPane.showMessageDialog(null, "Seu automóvel foi consertado e está pronto para ser usado!");
		}
		
		else {
			manutencao = true;
			JOptionPane.showMessageDialog(null, "Seu automóvel está em manutenção!");
		}
	}
	
	public static void imprimirAtributos () {
		if (automoveis.isEmpty())
			JOptionPane.showMessageDialog(null, "Você ainda não cadastrou nenhum automóvel!", "Ops!", JOptionPane.ERROR_MESSAGE);
		
		else {
			for (int i = 0; i < automoveis.size(); i++) {
				JOptionPane.showMessageDialog(null, "Automóvel " + (i + 1) + "\n\n" + "Tipo: " + automoveis.get(i).tipo + "\nMarca: " + automoveis.get(i).marca + "\nModelo: " + automoveis.get(i).modelo + "\nAno: " + automoveis.get(i).ano + "\nCombustível: " + automoveis.get(i).combustivel + "\nCor: " + automoveis.get(i).cor, "Automóveis Cadastrados", JOptionPane.INFORMATION_MESSAGE);
			}	
		}
	}
	
	public static void main(String[] args) {
		
		informarOpc();
		
	}

}
