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
        Deck objDeck = new Deck();
        Card objCard = new Card();
        Card objCard2 = new Card();
        objPlayer.inputName();
        System.out.println(objPlayer);
        objCard.setCard(4);
        System.out.println(objCard);
        objCard2.inputCard();
        System.out.println(objCard2);
    }

}