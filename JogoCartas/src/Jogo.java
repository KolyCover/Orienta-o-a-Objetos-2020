import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

//paus > copas > espadas > ouros.

public class Jogo {
	ArrayList<Carta> cartas = new ArrayList<Carta>();
	ArrayList<Carta> cartas_jogador1 = new ArrayList<Carta>();
	ArrayList<Carta> cartas_jogador2 = new ArrayList<Carta>();

	char[] valores = {'4', '5', '6', '7', 'Q', 'J', 'K', 'A', '2', '3'};
	char[] naipes = {'♦', '♠', '♥', '♣'};

	Random r = new Random();
	
	public String[] getCartas(ArrayList<Carta> lista) {
		ArrayList<String> listaCartas = new ArrayList<String>();
		
		for(Carta carta : lista) {
			listaCartas.add(Character.toString(carta.getValor()) + Character.toString(carta.getNaipe()));
		}
		
		return listaCartas.toArray(new String[0]);
	}

	public ArrayList<Carta> criaCartas() {
		for(int i = 0; i < valores.length; i++) {
			for(int j = 0; j < naipes.length; j++) {
				Carta c = new Carta(valores[i], naipes[j]);
				cartas.add(c);
			}
		}
		
		return cartas;
	}
	
	public void darCartas() {
		int carta;
		for(int i = 0; i < cartas.size(); i++) {
			carta = r.nextInt(cartas.size());
			cartas_jogador1.add(cartas.get(carta));
			cartas.remove(cartas.get(carta));
			
			carta = r.nextInt(cartas.size());
			cartas_jogador2.add(cartas.get(carta));
			cartas.remove(cartas.get(carta));
		}
	}
	
	public void jogo() {
		while(cartas_jogador1.size() > 0 || cartas_jogador2.size() > 0) {
			mostrarOpcoes("Suas Cartas", "Escolha uma carta para jogar", getCartas(cartas_jogador1));
		}
	}
	
	public void menu() {
		//String[] opcs = {"Jogar", "Carteira", "Regras do Jogo"};
		
	}
	
	public void mostrarInformacao(String titulo, String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public int mostrarOpcoes(String titulo, String mensagem, String[] opcs) {
		int opc = JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcs, opcs[0]);

		return opc;
	}
	
	public static void main(String[] args) {

	}

}