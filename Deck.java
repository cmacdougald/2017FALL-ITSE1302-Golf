/**
 * Deck Class for Golf Game
 * @author Chris M
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    //TODO: Array of Cards
    int intNumberOfDecks = 4;
    ArrayList<Card> aryDeck = new ArrayList<Card>();

    public Deck() {
        this.init(4);
    }

    public Deck(int intpNumberOfDecks) {
        this.init(intpNumberOfDecks);
    }

    private void init(int intpNumberOfDecks) {
        intNumberOfDecks = intpNumberOfDecks;
        int intCurrentCard = 0;
        int intCurrentDeck = 0;
        while(intCurrentDeck < intNumberOfDecks) {
            intCurrentCard = 1;
            while(intCurrentCard <= 52) {
                aryDeck.add(new Card(intCurrentCard));
                intCurrentCard++;
            }
            intCurrentDeck++;
        }
    }

    public void shuffle() {
        Collections.shuffle(this.aryDeck);
    }

    public String toString() {
        return aryDeck.toString();
    }
}