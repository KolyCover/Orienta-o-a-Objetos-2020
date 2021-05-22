public class Carta {
	private char valor;
	private char naipe;
	
	public Carta(char valor, char naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}
	
	public char getValor() {
		return valor;
	}
	
	public void setValor(char valor) {
		this.valor = valor;
	}
	
	public char getNaipe() {
		return naipe;
	}
	
	public void setNaipe(char naipe) {
		this.naipe = naipe;
	}
}