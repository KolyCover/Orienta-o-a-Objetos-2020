package Game;
public class Card {
	private char value;
	private char suit;
	private String name;
	
	public Card(char value, char suit) {
		this.value = value;
		this.suit = suit;
		this.name = value + "" + suit;
	}
	
	public char getValue() {
		return value;
	}
	
	public char getSuit() {
		return suit;
	}

	public String getName() {
		return name;
	}
}