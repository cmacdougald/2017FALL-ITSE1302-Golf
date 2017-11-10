/**
 * Deck Class for Golf Game
 * @author Chris M
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    int intNumberOfDecks = 4;
    int intAryDeckIndex = 0;
    int intShufflePercent = 75;
    ArrayList<Card> aryDeck = new ArrayList<Card>();

    public Deck() {
        this.init(4);
    }

    public Deck(int intpNumberOfDecks) {
        this.init(intpNumberOfDecks);
    }

    private void init(int intpNumberOfDecks) {
        this.intAryDeckIndex = 0;
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

    public void setShufflePercent(int intpShufflePercent) {
        if(intpShufflePercent <= 0) {
            System.err.println("Deck::setShufflePercent - Value to low default value used.");
            intpShufflePercent = 75;
        } else if (intpShufflePercent > 90) {
            System.err.println("Deck::setShufflePercent - Value to high default value used.");
            intpShufflePercent = 90;
        }
        this.intShufflePercent = intpShufflePercent;
    }

    public int getPercentOfCardsDealt() {
        return (this.intAryDeckIndex * 100) / this.aryDeck.size();
    }

    public Card getNextCard() {
        if(this.intAryDeckIndex < this.aryDeck.size()) {
            return this.aryDeck.get(this.intAryDeckIndex++);
        } else {
            return this.aryDeck.get(this.aryDeck.size() - 1);
        }
    }

    public Boolean shouldShuffle() {
        return (this.getPercentOfCardsDealt() >= this.intShufflePercent);
    }

    public void shuffle() {
        Collections.shuffle(this.aryDeck);
        this.intAryDeckIndex = 0;
    }

    public String toString() {
        return aryDeck.toString();
    }
}