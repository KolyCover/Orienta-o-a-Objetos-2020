import java.util.ArrayList;
import java.util.Random;

//paus > copas > espadas > ouros.

public class Game {
	ArrayList<Card> cards = new ArrayList<Card>();
	Player player1;
	Player player2;

	char[] valuesOrdered = {'4', '5', '6', '7', 'Q', 'J', 'K', 'A', '2', '3'};
	char[] suitsOrdered = {'♦', '♠', '♥', '♣'};

	Random r = new Random();
	
	public Game(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
	}
	
	public void play(Card card_player1, Card card_player2) {
		switch (checkWinner(card_player1, card_player2)) {
		case 1:
			player1.getCards().add(card_player2);
			player2.getCards().remove(card_player2);
		break;
		
		case 2:
			player2.getCards().add(card_player1);
			player1.getCards().remove(card_player1);
		break;
		}
	}
	
	//retorna array com os nomes das cartas de uma ArrayList em ordem
	public String[] getCards(ArrayList<Card> lista) {
		ArrayList<String> listaCartas = new ArrayList<String>();
		
		for(Card carta : lista) {
			listaCartas.add(Character.toString(carta.getValue()) + Character.toString(carta.getSuit()));
		}
		
		return listaCartas.toArray(new String[0]);
	}
	
	//retorna o index do caracter dentro da lista passada
		public int getIndexOfCharacter(char character, char[]characters) {
			int index = -1;
			
			for(int i = 0; i < characters.length; i++) {
				if(character == characters[i]) {
					index = i;
				}
			}
			
			return index;
		}

	//cria cartas de acordo com as ArrayLists de naipes e valores
	public ArrayList<Card> createCards() {
		for(int i = 0; i < valuesOrdered.length; i++) {
			for(int j = 0; j < suitsOrdered.length; j++) {
				Card c = new Card(valuesOrdered[i], suitsOrdered[j]);
				cards.add(c);
			}
		}
			
		return cards;
	}
	
	public void dealCards() {
		int cardIndex;
		while(cards.size() > 0) {
			cardIndex = r.nextInt(cards.size());
			player1.getCards().add(cards.get(cardIndex));
			cards.remove(cards.get(cardIndex));
			
			cardIndex = r.nextInt(cards.size());
			player2.getCards().add(cards.get(cardIndex));
			cards.remove(cards.get(cardIndex));
		}
	}
	
	//retorna -1 para erro, 1 para jogador 1 ganhador e 2 para jogador 2 ganhador
	public int checkWinner(Card c1, Card c2) {
		int result = -1;
		
		if(getIndexOfCharacter(c1.getValue(), valuesOrdered) > getIndexOfCharacter(c2.getValue(), valuesOrdered)) {
			result = 1;
		}
		
		else if(getIndexOfCharacter(c1.getValue(), valuesOrdered) < getIndexOfCharacter(c2.getValue(), valuesOrdered)) {
			result = 2;
		}
		
		else if(getIndexOfCharacter(c1.getValue(), valuesOrdered) == getIndexOfCharacter(c2.getValue(), valuesOrdered)) {
			if(getIndexOfCharacter(c1.getSuit(), suitsOrdered) > getIndexOfCharacter(c2.getSuit(), suitsOrdered)) {
				result = 1;
			}
			
			else if(getIndexOfCharacter(c1.getSuit(), suitsOrdered) < getIndexOfCharacter(c2.getSuit(), suitsOrdered)) {
				result = 2;
			}
		}
		
		return result;
	}
}