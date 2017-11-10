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

        // Logic to determine when to shuffle should be at the top of your game loop.
        //if(objDeck.shouldShuffle()) {
        //    objDeck.shuffle();
        //}


        //objPlayer.inputName();
        System.out.println(objDealer);
        System.out.println(objPlayer);
        System.out.println(objPlayer2);
        //objCard.setCard(4);
        //System.out.println(objCard);
        //objCard2.inputCard();
        //System.out.println(objCard2);
        objDeck.shuffle();
        //System.out.println(objDeck);
        Card objUnwantedCard = new Card();

        objPlayer.addCard(objDeck.getNextCard(), true);
        objPlayer.addCard(objDeck.getNextCard());
        objPlayer.addCard(objDeck.getNextCard(), true);
        objPlayer.addCard(objDeck.getNextCard());
        objPlayer.addCard(objDeck.getNextCard());
        objPlayer.addCard(objDeck.getNextCard());
        objPlayer.turnCardOver(0);
        objPlayer.turnCardOver(5);
        objPlayer.printHand();
        objPlayer.turnCardOver(5);
        objPlayer.printHand();
        objUnwantedCard = objPlayer.swapCard(5, objDeck.getNextCard());
        objPlayer.turnCardOver(5);
        objPlayer.turnCardOver(2);
        for(int intCounter = 0; intCounter <= 5; intCounter++) {
            objPlayer.turnCardOver(intCounter);
        }

        objPlayer.printHand();

        System.out.println("Unwanted Card: " + objUnwantedCard);
    }

}