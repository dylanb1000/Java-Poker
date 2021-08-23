
import java.util.Scanner;
public class PlayGame {
	public static void main(String[] args) {
		final int DRAWCOUNT=5;
		Scanner scnr=new Scanner(System.in);
		System.out.println("Welcome to Five Card Poker!");
		System.out.println("How many players will be playing?");
		boolean isNumber=false;
		String read="";
		int numberOfPlayers=0;
		//enter number of players. Checks if answer is valid
		while(isNumber!=true) {
			read=scnr.nextLine();
			try {
				numberOfPlayers=Integer.parseInt(read);
				if(numberOfPlayers<4 && numberOfPlayers>0) {
					isNumber=true;
				}
				else {
					System.out.println("Only 1-3 Players can Play");
				}	
			}
			catch(NumberFormatException e) {
				System.out.println("Type a valid answer!");
			}
		}
		///shows number of players in play and allows naming of players
		System.out.println("Number of Players: "+numberOfPlayers);
		Player[] players=new Player[numberOfPlayers+1];
		for(int i=0;i<numberOfPlayers;i++) {
			System.out.println("Please enter name of Player "+ (i + 1) );
			String name=scnr.nextLine();
			players[i]=new Player(name);
		}
		players[numberOfPlayers]=new Player("Dealer");
		
		//all players draw cards including the dealer
		boolean play2=true;
		while(play2!=false) {
			Deck deck=new Deck();
			for(int i=0;i<numberOfPlayers+1;i++) {
				for(int j=0;j<DRAWCOUNT;j++) {
					players[i].draw(deck.deal());
				}
			}
			
			//print players Cards and determines winner
			players[numberOfPlayers].cardsInHand();
			System.out.println("");
			for(int i=0;i<numberOfPlayers;i++) {
				printContent(players[i],players[numberOfPlayers]);
			}
			String answer="";
			System.out.println("Type Y to play again and anything else to exit");
			answer=scnr.nextLine();
			if(answer.contentEquals("Y") || answer.contentEquals("y")) {
				play2=true;
				for(int i=0;i<numberOfPlayers+1;i++) {
					players[i].discard();
				}
				for(int i=0;i<10;i++) {
					System.out.println("");
				}
			}
			else {
				play2=false;
			}
		}
		System.out.println("Thanks for Playing!!");
		scnr.close();
	}
	public static void printContent(Player player1,Player player2) {
		player1.cardsInHand();
		System.out.println(Score.scorePlayer(player1, player2));
		System.out.println("");
	}
	
}
