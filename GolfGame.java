/**
 * Main Class for Golf Game
 * @author Chris M
 * @version 1.0
 */
import java.util.Scanner;
import java.util.ArrayList;

public class GolfGame {

    Player objPlayer = new Player();
    Player objPlayer2 = new Player();
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
        objGolfGame.shuffle();
        objGolfGame.playRound();
        
    }

    public GolfGame() {
        objPlayer.clearHand();
        objDeck.shuffle();
        aryDiscardPile.clear();
    }

    public void addCards(Player objPlayer) {
        for(int intCounter = 0; intCounter < 6; intCounter++) {
            objPlayer.addCard(objDeck.getNextCard());
        }
    }

    public void playRound() {
        addCards(objPlayer);
        //Ask the player what they want to do.
        int intGetOption = 0;
        do {
            objPlayer.printHand();
            System.out.println("Enter which card you would like to flip? ");
            intGetOption = objScanner.nextInt();
            objPlayer.turnCardOver(intGetOption);
            
            
            System.out.println("Your logic goes here!");

        } while(!objPlayer.isTurnOver());
    }   

    private void shuffle() {
        if(objDeck.shouldShuffle()) {
            objDeck.shuffle();
        }
    }

}