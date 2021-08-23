import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards=new ArrayList<Card>(52);
	private Boolean[] drawn=new Boolean[52];
	private Suit[] suits=new Suit[] {
			Suit.HEARTS,
			Suit.SPADES,
			Suit.CLUBS,
			Suit.DIAMONDS};
	private Number[] numbers= new Number[] {
			Number.ACE,
			Number.TWO,
			Number.THREE,
			Number.FOUR,
			Number.FIVE,
			Number.SIX,
			Number.SEVEN,
			Number.EIGHT,
			Number.NINE,
			Number.TEN,
			Number.JACK,
			Number.QUEEN,
			Number.KING
	};
	private int count=-1;
	/**
	 * Constructor to populate the Deck class with every card combination.
	 */
	public Deck() {
		int count=0;
		for(int i=0;i<suits.length;i++) {
			for(int j=0;j<numbers.length;j++) {
				cards.add(new Card(numbers[j],suits[i]));
				drawn[count]=false;
				count+=1;
			}
		}
		Collections.shuffle(cards);
	}
	/**
	 * Method draw a random card from the Deck.
	 * @return A random card.
	 */
	public Card deal() {
		this.count+=1;
		drawn[this.count]=true;
		return cards.get(this.count);
		
	}
}
