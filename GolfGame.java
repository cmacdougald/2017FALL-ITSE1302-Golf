/**
 * Main Class for Golf Game
 * @author Chris M
 * @version 1.0
 */
import java.util.Scanner;
import java.util.ArrayList;

public class GolfGame {

    Player objPlayer = new Player("Player 1", 1000);
    Player objPlayer2 = new Player("Player 2", 1000);
    //Use the player contructor to create a special dealer object instance
    Player objDealer = new Player("Dealer", 0);
    Deck objDeck = new Deck();
    ArrayList<Card> aryDiscardPile = new ArrayList<Card>();
    Scanner objScanner = new Scanner(System.in);

    /*
     * Example of how to call classes.
     */
    public static void main(String [] strArgs) {
        //All game logic exists here
        GolfGame objGolfGame = new GolfGame();
        for(int intRound = 1; intRound <= 10; intRound++) {
            objGolfGame.shuffle();
            objGolfGame.playRound();
        }
        objGolfGame.determineWinner();
    }

    public GolfGame() {
        objDeck.shuffle();
        aryDiscardPile.clear();
    }

    public void addCards(Player objpPlayer) {
        objpPlayer.clearHand();
        for(int intCounter = 0; intCounter < 6; intCounter++) {
            objpPlayer.addCard(objDeck.getNextCard());
        }
        objpPlayer.turnCardOver(0);
        objpPlayer.turnCardOver(1);
    }

    public void playRound(Player objpPlayer) {
        addCards(objpPlayer);
        //Ask the player what they want to do.
        int intGetOption = 0;
        char chrOption = ' ';
        do {
            objpPlayer.printHand();
            System.out.println("What would you like to do: ");
            System.out.println("Use (D)iscard Pile - " + (aryDiscardPile.size() >= 1 ? aryDiscardPile.get(0) : "N/A"));
            System.out.println("(F)lip Card");
            System.out.println("(G)et Card from Deck");
            System.out.print("Enter your choice: ");
            chrOption = objScanner.next().charAt(0);
            System.out.println("Enter which card you would like to interact with (1-6)? ");
            intGetOption = objScanner.nextInt();
            intGetOption--;
            switch(chrOption) {
                case 'd': case 'D':
                    if(aryDiscardPile.size() >= 1) {
                        aryDiscardPile.add(objpPlayer.swapCard(intGetOption, aryDiscardPile.remove(0)));
                    }
                    break;
                case 'f': case 'F':
                    objpPlayer.turnCardOver(intGetOption);
                    break;
                case 'g': case 'G':
                    aryDiscardPile.add(objpPlayer.swapCard(intGetOption, objDeck.getNextCard()));
                    break;
            }
        } while(!objpPlayer.isTurnOver());
        objpPlayer.score();
    }

    public void playRound() {
        playRound(objPlayer);
        playRound(objPlayer2);
    }

    private void shuffle() {
        if(objDeck.shouldShuffle()) {
            objDeck.shuffle();
        }
    }

    public void determineWinner() {
        if(objPlayer.getScore() < objPlayer2.getScore()) {
            System.out.println(objPlayer.getName() + " wins!");
        } else {
            System.out.println(objPlayer2.getName() + " wins!");
        }
    }

}