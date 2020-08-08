import javax.swing.JOptionPane;

public class MeioDeTransporte {
	String locomocao, marca, modelo, combustivel;
	Float peso;
	int ano, tanque, capacidadeTanque;
	boolean ligado, estado;
	
	public void setAtributos(String loc, String marc, String mod, String comb, Float peso, int ano, int capTanq) {
		this.locomocao = loc;
		this.marca = marc;
		this.modelo = mod;
		this.combustivel = comb;
		this.peso = peso;
		this.ano = ano;
		this.capacidadeTanque = capTanq;
		this.tanque = 0;
		this.ligado = false;
		this.estado = false;
	}
	
	public void ligarDesligar() {
		if (this.ligado) {
			this.ligado = false;
			JOptionPane.showMessageDialog(null,"Seu veículo foi desligado!", "Painel", JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if (!this.ligado){
			this.ligado = true;
			JOptionPane.showMessageDialog(null,"Seu veículo foi ligado!", "Painel", JOptionPane.INFORMATION_MESSAGE);
		}
	};

	public void abastecer() {
		int combus;
		String[] combustiveis = {"Gasolina comum", "Gasolina aditivada", "Gasolina premium", "Etanol", "Etanol aditivado", "Diesel", "Diesel S-10", "Diesel aditivado", "Diesel Premium"};
		combus = JOptionPane.showOptionDialog(null, "Qual tipo de combustível você gostaria de colocar no seu veículo?", "Posto de combustível", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, combustiveis, combustiveis[0]);
	
		String[] quantidades = new String[this.capacidadeTanque / 10];
		
		for(int i = 0, j = 10; i < this.capacidadeTanque / 10; i++, j+=10) {
			quantidades[i] = Integer.toString(j);
		}
		
	    int qtd = Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha a quantidade, em litros, de " + combustiveis[combus] + " que você deseja colocar no veículo.", "Posto de combustível", JOptionPane.INFORMATION_MESSAGE, null, quantidades, quantidades [0]).toString());
		
	    while (this.tanque + qtd > this.capacidadeTanque && this.capacidadeTanque - this.tanque >= 10) {
			JOptionPane.showMessageDialog(null, "O tanque de seu veículo não suporta a quantidade de combustível escolhida. Escolha um valor inferior ou igual a " + (this.capacidadeTanque - this.tanque) + " litros.", "Ops", JOptionPane.ERROR_MESSAGE);
		    qtd = Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha a quantidade, em litros, de " + combustiveis[combus] + " que você deseja colocar no veículo.", "Posto de combustível", JOptionPane.INFORMATION_MESSAGE, null, quantidades, quantidades [0]).toString());
	    }
	    
	    this.tanque += qtd;
		
		JOptionPane.showMessageDialog(null,"Seu veículo foi abastecido com " + qtd + " litros de " + combustiveis[combus] + ".", "Posto de combustível", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void viajar() {
		this.estado = true;
		this.tanque -= 10; //cada vez que o carro roda, ele gasta 10 litros de combustível
		JOptionPane.showMessageDialog(null,"Meio de transporte em movimento", "Painel", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void pararViajem() {
		this.estado = false;
		JOptionPane.showMessageDialog(null,"Viagem concluida com sucesso!", "Painel", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String InformarAtributos() {
		String infos = "Meio de Transporte: " + this.locomocao + "\n\n" +
				"Marca: " + this.marca + "\n" +
                "Modelo: " + this.modelo + "\n" +
                "Ano de lançamento: " + this.ano + "\n\n" +
                "Tipo de combustivel: " + this.combustivel + "\n" +
                "Total de litros no tanque: " + this.tanque + "\n" +
                "Máximo de litros no tanque: " + this.capacidadeTanque + "\n" +
                "Ligado/Desligado: " + (this.ligado ? "Ligado": "Desligado");

		return infos;
	}

}
