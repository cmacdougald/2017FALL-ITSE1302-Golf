/**
 * Main Class for Golf Game
 * @author Chris M
 * @version 1.0
 */

public class GolfGame {

    /*
     * Example of how to call classes.
     */
    public static void main(String [] strArgs) {
        //All game logic exists here
        
        Player objPlayer = new Player();
        Player objPlayer2 = new Player();
        //Use the player contructor to create a special dealer object instance
        Player objDealer = new Player("Dealer", 0);
        Deck objDeck = new Deck();
        Card objCard = new Card(24);
        Card objCard2 = new Card();
        //objPlayer.inputName();
        System.out.println(objDealer);
        System.out.println(objPlayer);
        System.out.println(objPlayer2);
        //objCard.setCard(4);
        System.out.println(objCard);
        //objCard2.inputCard();
        System.out.println(objCard2);
    }

}