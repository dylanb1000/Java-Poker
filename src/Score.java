import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;





public class Score {
private static int FIRSTCARDIDX=0;
private static int SECONDCARDIDX=1;
private static int THIRDCARDIDX=2;
private static int FOURTHCARDIDX=3;
private static int FIFTHCARDIDX=4;
	/**
	 * Method used to compare two players hands against each other.
	 * @param player1 - player to be compared
	 * @param player2 - player to be compared
	 * @return A String that will state which players hand won and how they won.
	 */
	public static String scorePlayer(Player player1, Player player2) {
		Card[] cards1=player1.getCards();
		Card[] cards2=player2.getCards();
		int player1Score=0;
		int player2Score=0;
		if(onePairCheck(cards1,player1)==true) {player1Score=1;}
		if(onePairCheck(cards2,player2)==true) {player2Score=1;}
		if(twoPairCheck(cards1,player1)==true) {player1Score=2;}
		if(twoPairCheck(cards2,player2)==true) {player2Score=2;}
		if(threeOfAKindCheck(cards1,player1)==true) {player1Score=3;}
		if(threeOfAKindCheck(cards2,player2)==true) {player2Score=3;}
		if(straightCheck(cards1)==true) {player1Score=4;}
		if(straightCheck(cards2)==true) {player2Score=4;}
		if(flushCheck(cards1)==true) {player1Score=5;}
		if(flushCheck(cards2)==true) {player2Score=5;}
		if(fullHouseCheck(cards1)==true) {player1Score=6;}
		if(fullHouseCheck(cards2)==true) {player2Score=6;}
		if(fourOfAKindCheck(cards1,player1)==true) {player1Score=7;}
		if(fourOfAKindCheck(cards2,player2)==true) {player2Score=7;}
		if(straightFlushCheck(cards1)==true) {player1Score=8;}
		if(straightFlushCheck(cards2)==true) {player2Score=8;}
		if(royalFlushCheck(cards1)==true) {player1Score=9;}
		if(royalFlushCheck(cards2)==true) {player2Score=9;}
		if(player1Score>player2Score) {
			switch(player1Score){
				case 1:return player1.getName()+" wins with One Pair";
				case 2:return player1.getName()+" wins with a Two Pairs";
				case 3:return player1.getName()+" wins with a Three of a Kind";
				case 4:return player1.getName()+" wins with a Straight";
				case 5:return player1.getName()+" wins with a Flush";
				case 6:return player1.getName()+" wins with a Full House";
				case 7:return player1.getName()+" wins with a Four of a Kind";
				case 8:return player1.getName()+" wins with a Straight Flush";
				case 9:return player1.getName()+" wins with a Royal Flush";
				
			}
		}
		else if(player2Score>player1Score){
			switch(player2Score){
				case 1:return player2.getName()+" wins with One Pair";
				case 2:return player2.getName()+" wins with Two Pairs";
				case 3:return player2.getName()+" wins with a Three of a Kind";
				case 4:return player2.getName()+" wins with a Straight";
				case 5:return player2.getName()+" wins with a Flush";
				case 6:return player2.getName()+" wins with a Full House";
				case 7:return player2.getName()+" wins with a Four of a Kind";
				case 8:return player2.getName()+" wins with a Straight Flush";
				case 9:return player2.getName()+" wins with a Royal Flush";
			
			}
		}
		else if(player1Score==player2Score) {
			switch(player1Score) {
			case 1:
				if(player1.onePairValue.number>player2.onePairValue.number) {
					return player1.getName()+" wins with One Pair"+"("+player1.onePairValue+")";
				}
				else if(player2.onePairValue.number>player1.onePairValue.number) {
					return player2.getName()+" wins with One Pair"+"("+player2.onePairValue+")";
				}
				break;
			case 2:
				if(player1.twoPairValue.number>player2.twoPairValue.number) {
					return player1.getName()+" wins with Two Pairs"+"("+player1.twoPairValue+")";
				}
				else if(player2.twoPairValue.number>player1.twoPairValue.number) {
					return player2.getName()+" wins with Two Pairs"+"("+player2.twoPairValue+")";
				}
				break;
			case 3:
				if(player1.threeOfAKindValue.number>player2.threeOfAKindValue.number) {
					return player1.getName()+" wins with a Three of a Kind"+"("+player1.threeOfAKindValue+")";
				}
				else if(player2.threeOfAKindValue.number>player1.threeOfAKindValue.number) {
					return player2.getName()+" wins with a Three of a Kind"+"("+player2.threeOfAKindValue+")";
				}
				break;
				
			case 6:
				if(player1.threeOfAKindValue.number>player2.threeOfAKindValue.number) {
					return player1.getName()+" wins with a Full House"+"("+player1.threeOfAKindValue+")";
				}
				else if(player2.threeOfAKindValue.number>player1.threeOfAKindValue.number) {
					return player2.getName()+" wins with a Full House"+"("+player2.threeOfAKindValue+")";
				}
				break;
			case 7:
				if(player1.fourOfAKindValue.number>player2.fourOfAKindValue.number) {
					return player1.getName()+" wins with a Four of a Kind"+"("+player1.fourOfAKindValue+")";
				}
				else if(player2.fourOfAKindValue.number>player1.fourOfAKindValue.number) {
					return player2.getName()+" wins with a Four of a Kind"+"("+player2.fourOfAKindValue+")";
				}
				break;
			}
			if(compareHC(player1,player2)==true) {
				return player1.getName()+" wins with High Card";
			}
			else if(compareHC(player2,player1)==true) {
				return player2.getName()+" wins with High Card";
			}
			else {
				return "Tie";
			}
			
		}
		return "Tie";
		
	}
	/**
	 * Method to check if the inputed cards have the values for a Royal Flush. 
	 * @param cards
	 * @return a boolean value representing if the array of cards has the correct condition to satisfy a Royal Flush.
	 */
	public static boolean royalFlushCheck(Card[] cards) {
		if((flushCheck(cards)==true) &&
			Arrays.asList(cards).contains(Number.ACE) && Arrays.asList(cards).contains(Number.KING) &&
			Arrays.asList(cards).contains(Number.QUEEN)&&
			Arrays.asList(cards).contains(Number.JACK)&&
			Arrays.asList(cards).contains(Number.TEN)){
				return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Method to check if the inputed cards have the values for a Straight Flush. 
	 * @param cards
	 * @return a boolean value representing if the array of cards has the correct condition to satisfy a Straight Flush.
	 */
	public static boolean straightFlushCheck(Card[] cards) {
		if(straightCheck(cards)==true & flushCheck(cards)==true) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Method to check if the inputed cards have the values for a Four of a Kind. 
	 * @param cards
	 * @return a boolean value representing if the array of cards has the correct condition to satisfy a Four of a Kind.
	 */
	public static boolean fourOfAKindCheck(Card[] cards,Player player) {
		for(int i=0;i<cards.length;i++) {
			int Count=0;
			for(int j=i+1;j<cards.length;j++) {
				if(cards[i].getNumber()==cards[j].getNumber()) {
					Count+=1;
					if(Count==3) {
						player.fourOfAKindValue=cards[i].getNumber();
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Method to check if the inputed cards have the values for a Full House. 
	 * @param cards
	 * @return a boolean value representing if the array of cards has the correct condition to satisfy a Full House.
	 */
	public static boolean fullHouseCheck(Card[] cards) {
		//creating copy of cards
		ArrayList<Card> copy=new ArrayList<Card>();
		for(int i=0;i<cards.length;i++) {
			copy.add(cards[i]);
		}
		//method
		for(int i=0;i<copy.size();i++) {
			int Count=0;
			for(int j=i+1;j<copy.size();j++) {
				if(copy.get(i).getNumber()==copy.get(j).getNumber()) {
					Count+=1;
					if(Count==2) {
						Number trip=copy.get(i).getNumber();
						for(int k=0;k<copy.size();k++) {
							for(int l=k+1;l<copy.size();l++) {
								if(copy.get(i).getNumber()!=trip && copy.get(i).getNumber()==copy.get(j).getNumber()) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	/**
	 * Method to check if the inputed cards have the values for a Flush. 
	 * @param cards
	 * @return a boolean value representing if the array of cards has the correct condition to satisfy a Flush.
	 */
	public static boolean flushCheck(Card[] cards) {
		Suit suit=cards[FIRSTCARDIDX].getSuit();
		if(cards[SECONDCARDIDX].getSuit()==suit && cards[THIRDCARDIDX].getSuit()==suit && cards[FOURTHCARDIDX].getSuit()==suit && cards[FIFTHCARDIDX].getSuit()==suit) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Method to check if the inputed cards have the values for a Straight. 
	 * @param cards
	 * @return a boolean value representing if the array of cards has the correct condition to satisfy a Straight.
	 */
	public static boolean straightCheck(Card[] cards) {
		int[] sortedNumbers=new int[cards.length];
		for(int i=0;i<cards.length;i++) {
			sortedNumbers[i]=cards[i].getNumber().number;
		}
		Arrays.sort(sortedNumbers);
		if(Math.abs(sortedNumbers[FIRSTCARDIDX]-sortedNumbers[SECONDCARDIDX])==1 && Math.abs(sortedNumbers[SECONDCARDIDX]-sortedNumbers[THIRDCARDIDX])==1 && Math.abs(sortedNumbers[THIRDCARDIDX]-sortedNumbers[FOURTHCARDIDX])==1 && Math.abs(sortedNumbers[FOURTHCARDIDX]-sortedNumbers[FIFTHCARDIDX])==1) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Method to check if the inputed cards have the values for a Three of a Kind. 
	 * @param cards
	 * @return a boolean value representing if the array of cards has the correct condition to satisfy a Three of a Kind.
	 */
	public static boolean threeOfAKindCheck(Card[] cards,Player player) {
		for(int i=0;i<cards.length;i++) {
			int Count=0;
			for(int j=i+1;j<cards.length;j++) {
				if(cards[i].getNumber()==cards[j].getNumber()) {
					Count+=1;
					if(Count==2) {
						player.threeOfAKindValue=cards[i].getNumber();
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Method to check if the inputed cards have the values for Two Pairs. 
	 * @param cards
	 * @return a boolean value representing if the array of cards has the correct condition to satisfy Two Pairs.
	 */
	public static boolean twoPairCheck(Card[] cards,Player player) {
		int Count=0;
		Number high=Number.TWO;
		for(int i=0;i<cards.length;i++) {
			for(int j=i+1;j<cards.length;j++) {
				if(cards[i].getNumber()==cards[j].getNumber()) {
					Count+=1;
					if(cards[i].getNumber().number>high.number) {
						high=cards[i].getNumber();
					}
					break;
				}
			}
		}
		if(Count>=2) {
			player.twoPairValue=high;
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method to check if the inputed cards have the values for a One Pair. 
	 * @param cards
	 * @return a boolean value representing if the array of cards has the correct condition to satisfy a One Pair.
	 */
	public static boolean onePairCheck(Card[] cards,Player player) {
		for(int i=0;i<cards.length;i++) {
			for(int j=i+1;j<cards.length;j++) {
				if(cards[i].getNumber()==cards[j].getNumber()) {
					player.onePairValue=cards[i].getNumber();
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Method to check which player has the High Card. 
	 * @param player1 - player to be compared
	 * @param player2 - player to be compared
	 * @return a boolean value representing if player one has a higher card than player two.
	 */
	public static boolean compareHC(Player player1,Player player2) {
		int[] sortedNumbers1=new int[player1.getCards().length];
		for(int i=0;i<player1.getCards().length;i++) {
			sortedNumbers1[i]=player1.getCards()[i].getNumber().number;
		}
		Arrays.sort(sortedNumbers1);
		int[] sortedNumbers2=new int[player2.getCards().length];
		for(int i=0;i<player2.getCards().length;i++) {
			sortedNumbers2[i]=player2.getCards()[i].getNumber().number;
		}
		Arrays.sort(sortedNumbers2);
		if(sortedNumbers1[FIFTHCARDIDX]>sortedNumbers2[FIFTHCARDIDX]) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
