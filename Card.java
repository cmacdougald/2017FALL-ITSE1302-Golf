/**
 * Card Class for Golf Game
 * @author Chris M
 * @version 1.0
 */

import java.util.Scanner;


/*
 * Card class for 
 */
public class Card {

    int intCard = 0;

    /**
     * Default Constructor for card class assigns it a value of ace of clubs.
     */
    public Card() {
        this.setCard(1);
    }
    /**
     * Constructor for the card class where you can assign it a card value.
     */
    public Card(int intpCard) {
        this.setCard(intpCard);
    }

    /*
     * Sets the value of the card.
     * TODO: add logic to prevent invalid values
     */
    public void setCard(int intpCard) {
        this.intCard = intpCard;
    }
    
    /*
     * Returns the value of the card.
     */
    private int getCard() {
        return intCard;
    }

    /*
     * Return the face value of the card.
     */
    public int getFaceValue() {
        return ((this.getCard() - 1 ) % 13) + 1;
    }
    
        /*
     * Return the face value of the card.
     */
    public String getFaceString() {
        int intValue = getFaceValue();
        String strFace = "" + intValue;
        if (1 == intValue) {
            strFace = "Ace";
        }
        if (11 == intValue) {
            strFace = "Jack";
        }
        if (12 == intValue) {
            strFace = "Queen";
        }
        if (13 == intValue) {
            strFace = "King";
        }

        return strFace;
    }
    /*
     * Return the suite value of the card.
     */
    public int getSuiteValue() {
        return (this.getCard() - 1) / 13;
    }

    public String getSuiteString() {
        int intValue = getSuiteValue();
        String strSuite = "" + intValue;
        if (0 == intValue) {
            strSuite = "Clubs";
        }
        if (1 == intValue) {
            strSuite = "Diamonds";
        }
        if (2 == intValue) {
            strSuite = "Hearts";
        }
        if (3 == intValue) {
            strSuite = "Spades";
        }
        return strSuite;
    }
    /* 
     * Simple function to enter a card for testing purposes.
     */
    public void inputCard() {
        Scanner objScanner = new Scanner(System.in);
        System.out.print("Please enter a number between 1 and 52: ");
        this.setCard(objScanner.nextInt());
    }

    /*
     * Returns the string value of this object.
     */
    public String toString() {
        return "{\"Face\": " + this.getFaceString() +
            ", \"Suite\": " + this.getSuiteString() + "}";
    }
}