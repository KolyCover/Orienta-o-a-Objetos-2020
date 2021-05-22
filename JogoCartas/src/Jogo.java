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
	
	//retorna array com os nomes das cartas de uma ArrayList em ordem
	public String[] pegarCartas(ArrayList<Carta> lista) {
		ArrayList<String> listaCartas = new ArrayList<String>();
		
		for(Carta carta : lista) {
			listaCartas.add(Character.toString(carta.getValor()) + Character.toString(carta.getNaipe()));
		}
		
		return listaCartas.toArray(new String[0]);
	}
	
	//retorna o index do caracter dentro da lista passada
		public int pegarIndex(char character, char[]characters) {
			int index = -1;
			
			for(int i = 0; i < characters.length; i++) {
				if(character == characters[i]) {
					index = i;
				}
			}
			
			return index;
		}

	//cria cartas de acordo com as ArrayLists de naipes e valores
	public ArrayList<Carta> criarCartas() {
		for(int i = 0; i < valores.length; i++) {
			for(int j = 0; j < naipes.length; j++) {
				Carta c = new Carta(valores[i], naipes[j]);
				cartas.add(c);
			}
		}
			
		return cartas;
	}
	
	public void darCartas() {
		int indice_carta;
		while(cartas.size() > 0) {
			indice_carta = r.nextInt(cartas.size());
			cartas_jogador1.add(cartas.get(indice_carta));
			cartas.remove(cartas.get(indice_carta));
			
			indice_carta = r.nextInt(cartas.size());
			cartas_jogador2.add(cartas.get(indice_carta));
			cartas.remove(cartas.get(indice_carta));
		}
	}
	
	//retorna -1 para erro, 1 para jogador 1 ganhador e 2 para jogador 2 ganhador
	public int verificarGanhador(Carta c1, Carta c2) {
		int resultado = -1;
		
		if(pegarIndex(c1.getValor(), valores) > pegarIndex(c2.getValor(), valores)) {
			resultado = 1;
		}
		
		else if(pegarIndex(c1.getValor(), valores) < pegarIndex(c2.getValor(), valores)) {
			resultado = 2;
		}
		
		else if(pegarIndex(c1.getValor(), valores) == pegarIndex(c2.getValor(), valores)) {
			if(pegarIndex(c1.getNaipe(), naipes) > pegarIndex(c2.getNaipe(), naipes)) {
				resultado = 1;
			}
			
			else if(pegarIndex(c1.getNaipe(), naipes) < pegarIndex(c2.getNaipe(), naipes)) {
				resultado = 2;
			}
		}
		
		return resultado;
	}
	
	public void jogar() {
		criarCartas();
		darCartas();
		
		int indiceCarta_j1;
		int indiceCarta_j2;
		Carta cartaj1;
		Carta cartaj2;
		int index = 1; //contador de rodadas
		
		while(cartas_jogador1.size() > 0 && cartas_jogador2.size() > 0) {
			indiceCarta_j1 = mostrarOpcoes("Rodada " + index, "Escolha uma carta para jogar", pegarCartas(cartas_jogador1));
			indiceCarta_j2 = r.nextInt(this.cartas_jogador2.size());
			cartaj1 = cartas_jogador1.get(indiceCarta_j1);
			cartaj2 = cartas_jogador2.get(indiceCarta_j2);
			
			switch (verificarGanhador(cartaj1, cartaj2)) {
			case 1:
				cartas_jogador1.add(cartaj2);
				cartas_jogador2.remove(indiceCarta_j2);
				mostrarInformacao("Você ganhou essa rodada!", "Sua carta: " + cartaj1.getValor() + cartaj1.getNaipe() + "\nCarta do bot: " + cartaj2.getValor() + cartaj2.getNaipe());
			break;
			
			case 2:
				cartas_jogador2.add(cartas_jogador1.get(indiceCarta_j1));
				cartas_jogador1.remove(indiceCarta_j1);
				mostrarInformacao("Você perdeu essa rodada!", "Sua carta: " + cartaj1.getValor() + cartaj1.getNaipe() + "\nCarta do bot: " + cartaj2.getValor() + cartaj2.getNaipe());
			break;
			}
			
			index++;			
		}
		
		if(cartas_jogador1.size() == 0) {
			mostrarInformacao("Você perdeu o jogo!", "Infelizmente não foi dessa vez, fica para a próxima!");
		}
		
		else if(cartas_jogador2.size() == 0) {
			mostrarInformacao("Você ganhou o jogo!", "Parabéns! Você está com sorte hoje");
		}
	}
	
	public void mostrarInformacao(String titulo, String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public int mostrarOpcoes(String titulo, String mensagem, String[] opcs) {
		int opc = JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcs, opcs[0]);

		return opc;
	}
	
	public static void main(String[] args) {
		Jogo j = new Jogo();
		
		j.mostrarInformacao("Jogo das Cartas", "Bem-vindo(a) ao jogos das Cartas");
		j.jogar();
	}

}