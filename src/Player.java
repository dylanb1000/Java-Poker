//import uci.UCIException;

public class Player {
private int MAXCARDS=5; 
private int LASTCARDIDX=4;
public Number onePairValue;
public Number twoPairValue;
public Number threeOfAKindValue;
public Number fourOfAKindValue;
private Card[] hand=new Card[MAXCARDS];
private String name;

	/**
	 * Constructor for the Player class
	 * @param name 
	 */
	public Player(String name) {
		this.name=name;
	}
	/**
	 * Accessor method to retrieve players name
	 * @return Players name as a String
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Accessor method to retrieve players cards
	 * @return Players card in a Card Array
	 */
	public Card[] getCards(){
		Card[] cards=new Card[this.hand.length];
		for(int i=0;i<this.hand.length;i++) {
			cards[i]=this.hand[i];
		}
		return cards;
	}
	/**
	 * Method to add a specific card to the players hand
	 * @param card - Card to be added to players hand
	 */
	public void draw(Card card) {
		int count=0;
		while(true) {
			if(count>LASTCARDIDX) {
				System.out.println("Hand is full");
				break;
			}
			else if(hand[count]==null) {
				hand[count]=card;
				break;
			}
			else {
				count+=1;
			}
			
		}
	}
	/**
	 * Method to print players cards in the console
	 * 
	 */
	public void cardsInHand() {
		System.out.print(name+"'s Cards: ");
		for(int i=0;i<hand.length-1;i++) {
			if(this.hand[i]==null) {
				System.out.print("null"+ ", ");
			}
			else {
				System.out.print(this.hand[i].toString()+", ");
			}
		}
		if(this.hand[LASTCARDIDX]==null) {
			System.out.print("null");
		}
		else {
			System.out.print(this.hand[LASTCARDIDX].toString()+"\n");
		}
	}
	public void discard() {
		this.hand=new Card[MAXCARDS];
	}
}
