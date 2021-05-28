import java.util.ArrayList;
import java.util.Random;

//paus > copas > espadas > ouros.

public class Game {
	private ArrayList<Card> deck = new ArrayList<Card>();
	Player player1;
	Player player2;

	char[] valuesOrdered = {'4', '5', '6', '7', 'Q', 'J', 'K', 'A', '2', '3'};
	char[] suitsOrdered = {'♦', '♠', '♥', '♣'};
	
	public Game(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
	}
	
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
	
	//cria cartas de acordo com as ArrayLists de naipes e valores
		public ArrayList<Card> createCards() {
			for(int i = 0; i < valuesOrdered.length; i++) {
				for(int j = 0; j < suitsOrdered.length; j++) {
					Card c = new Card(valuesOrdered[i], suitsOrdered[j]);
					deck.add(c);
				}
			}
				
			return deck;
		}
		
		//distribui 14 cartas para cada jogador, ficando 12 no baralho
		public void dealCards() {
			int cardIndex;
			Random r = new Random();
			
			while(deck.size() > 12) {
				cardIndex = r.nextInt(deck.size());
				player1.getCards().add(deck.get(cardIndex));
				deck.remove(deck.get(cardIndex));
				
				cardIndex = r.nextInt(deck.size());
				player2.getCards().add(deck.get(cardIndex));
				deck.remove(deck.get(cardIndex));
			}
		}
	
	public int play(Card card_player1, Card card_player2, Card turned) {
		int winner = checkWinner(card_player1, card_player2, turned);
		
		switch (winner) {
		case 1:
			player1.getCards().add(card_player2);
			player2.getCards().remove(card_player2);
		break;
		
		case 2:
			player2.getCards().add(card_player1);
			player1.getCards().remove(card_player1);
		break;
		}
		
		return winner;
	}
	
	//retorna o "vira" da rodada (indexVira + 1 == carta mais forte)
	public Card turnCard() {
		Random r = new Random();
		Card card = deck.get(r.nextInt(deck.size()));
		
		return card;
	}
	
	//retorna -1 para erro, 1 para jogador 1 ganhador e 2 para jogador 2 ganhador
	public int checkWinner(Card c1, Card c2, Card turned) {
		int result = -1;
		
		if(getIndexOfCharacter(c1.getValue(), valuesOrdered) == getIndexOfCharacter(c2.getValue(), valuesOrdered)) {
			if(getIndexOfCharacter(c1.getSuit(), suitsOrdered) > getIndexOfCharacter(c2.getSuit(), suitsOrdered)) {
				result = 1;
			}
			
			else if(getIndexOfCharacter(c1.getSuit(), suitsOrdered) < getIndexOfCharacter(c2.getSuit(), suitsOrdered)) {
				result = 2;
			}
		}
		
		else if(getIndexOfCharacter(c1.getValue(), valuesOrdered) == getIndexOfCharacter(turned.getValue(), valuesOrdered) + 1) {
			result = 1;
		}
		
		else if(getIndexOfCharacter(c2.getValue(), valuesOrdered) == getIndexOfCharacter(turned.getValue(), valuesOrdered) + 1) {
			result = 2;
		}
		
		else if(getIndexOfCharacter(c1.getValue(), valuesOrdered) > getIndexOfCharacter(c2.getValue(), valuesOrdered)) {
			result = 1;
		}
		
		else if(getIndexOfCharacter(c1.getValue(), valuesOrdered) < getIndexOfCharacter(c2.getValue(), valuesOrdered)) {
			result = 2;
		}
		
		return result;
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
}