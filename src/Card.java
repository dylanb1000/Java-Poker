
public class Card {
	private Number number;
	private Suit suit;
	/**
	 * Constructor used to create a card.
	 * @param number - enum type representing the number of the card.
	 * @param suit - enum type representing the suit of the card.
	 */
	public Card(Number number,Suit suit) {
		this.suit=suit;
		this.number=number;
	}
	/**
	 * Method used to create a string representation of the card.
	 * @return A String that states the cards number and suit.
	 */
	public String toString() {
		return this.number.toString()+" of "+this.suit.toString();
	}
	/**
	 * Accessor Method to retrieve cards number.
	 * @return the cards number.
	 */
	public Number getNumber() {
		return this.number;
	}
	/**
	 * Accessor Method to retrieve cards suit.
	 * @return the cards suit.
	 */
	public Suit getSuit() {
		return this.suit;
	}

}
