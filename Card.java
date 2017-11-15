/**
 * Card Class for Golf Game
 * @author Chris M
 * @version 1.0
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

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

    public static ArrayList<Integer> getFaceValueCount(ArrayList<Card> aryCards) {
        ArrayList<Integer> aryFaceValueCount = new ArrayList<Integer>();
        for(int intCounter = 0; intCounter <= 13; intCounter++) {
            aryFaceValueCount.add(0);
        }
        for(int intIndex = 0; intIndex < aryCards.size(); intIndex++) {
            int intTempFaceValue = aryCards.get(intIndex).getFaceValue();
            int intTempCount = aryFaceValueCount.get(intTempFaceValue);
            intTempCount++;
            aryFaceValueCount.set(intTempFaceValue, intTempCount);
            //System.out.println(aryFaceValueCount);
        }
        return aryFaceValueCount;
    } 
    
        /*
     * Return the face value of the card.
     */
    public String getFaceString() {
        int intValue = getFaceValue();
        String strFace = "";
        switch (intValue) {
            case 1:
                strFace = "Ace";
                break;
            case 11:
                strFace = "Jack";
                break;
            case 12:
                strFace = "Queen";
                break;
            case 13:
                strFace = "King";
                break;
            default:
                strFace += intValue;
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
        String strSuite = "";
        switch (intValue) {
            case 0:
                strSuite = "Clubs";
                break;
            case 1:
                strSuite = "Diamonds";
                break;
            case 2:
                strSuite = "Hearts";
                break;
            case 3:
                strSuite = "Spades";
                break;
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
        return this.getFaceString() + " of " + this.getSuiteString();
    }

    public String toJSON() {
        return "{\"Face\": " + this.getFaceString() +
            ", \"Suite\": " + this.getSuiteString() + "}";
    }
}