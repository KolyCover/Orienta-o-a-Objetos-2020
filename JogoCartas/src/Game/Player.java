package Game;
import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Card> cards = new ArrayList<Card>();
	private double balance;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String[] getCardsNames() {
		String[] cardsNames = new String[this.cards.size()];
		
		for(int i = 0; i < cardsNames.length; i++) {
			cardsNames[i] = cards.get(i).getName();
		}
		
		return cardsNames;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	} 
	
}
