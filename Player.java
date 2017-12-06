/**
 * Player Class for Golf Game
 * @author Chris M
 * @version 1.0
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Player {

	private Scanner objScanner = new Scanner(System. in );
	private static int intNumberOfPlayers = 1;
	private String strName = "No One";
	private int intCurrentMoney = 100;
	private int intCurrentBet = 10;
	private int intCurrentScore = 0;
	//Array Hand
	private ArrayList < Card > aryHand = new ArrayList < Card > ();
	private ArrayList < Boolean > aryFaceUp = new ArrayList < Boolean > ();

	/**
     * Default constructor for player class setup players based on numbers.
     */
	public Player() {
		this.setName("Player " + intNumberOfPlayers++);
		this.setMoney(1000);
		this.setBet(0);
	}

	/**
     * Constructor where you just assign the money the player starts.
     */
	public Player(int intpMoney) {
		this.setName("Player " + intNumberOfPlayers++);
		this.setMoney(intpMoney);
		this.setBet(0);
	}

	/**
     * Constructor for player where you specify the name and the money the player starts with.
     */
	public Player(String strpName, int intpMoney) {
		intNumberOfPlayers++;
		this.setName(strpName);
		this.setMoney(intpMoney);
		this.setBet(0);
	}

	/**
	 * Adds a card face down into the players hand.
	 */
	public Boolean addCard(Card objpCard) {
		return this.addCard(objpCard, false);
	}

	/**
	 * Adds a card either face up or face down.
	 */
	public Boolean addCard(Card objpCard, Boolean boolFaceUp) {
		if (this.aryHand.size() < 6) {
			this.aryHand.add(objpCard);
			this.aryFaceUp.add(boolFaceUp);
			return true;
		}
		return false;
	}

	/**
	 * Calculates the score of the player.
	 */
	public int calculateScore() {
		int intScore = 0;
		int intCardValue = 0;
		for (int intIndex = 0;
		intIndex < this.aryHand.size();
		intIndex++) {
			intCardValue = this.aryHand.get(intIndex).getFaceValue();
			switch (intCardValue) {
			case 1:
				intCardValue = -2;
				break;
			case 13:
			case 12:
				intCardValue = 0;
				break;
			}
			intScore += intCardValue;
		}
		intScore -= this.getScoreOfPairs();
		return intScore;
	}

	/**
	 * Clears the hand of all cards and the cards that are flipped over is reset.
	 */
	public void clearHand() {
		this.aryHand.clear();
		this.aryFaceUp.clear();
	}
	/**
	 * Clears out the users current score.
	 */
	public void clearScore() {
		this.intCurrentScore = 0;
	}
	/**
     * Get the players current bet.
     */
	public int getBet() {
		return this.intCurrentBet;
	}
	/*
     * Get the players current money.
     */
	public int getMoney() {
		return this.intCurrentMoney;
	}
	/*
     * Get the players name.
     */
	public String getName() {
		return this.strName;
	}
	/**
	 * Returns players score.
	 */
	public int getScore() {
		return this.intCurrentScore;
	}
	/**
	 * Figure out if there are pairs of numbers for scoring purposes.
	 */
	private int getScoreOfPairs() {
		ArrayList<Integer> aryFaceValueCount = Card.getFaceValueCount(this.aryHand);
		int intSum = 0;
		for(int intIndex = 0; intIndex < aryFaceValueCount.size(); intIndex++) {
			if (aryFaceValueCount.get(intIndex) % 2 == 0) {
				intSum += (intIndex * aryFaceValueCount.get(intIndex));
			}			
		}
		//System.out.println(intSum);
		return intSum;
	}
	/**
	 * Input the users bet.
	 */
	public void inputBet() {
		System.out.print(this.getName() + " you have $" + this.getMoney() + " how much would you like to bet? ");
		this.setBet(objScanner.nextInt());
	}
	/**
     * Prompt the player for the name.
     */
	public void inputName() {
		System.out.print("Please enter your name: ");
		this.setName(objScanner.nextLine());
	}
	/**
	 * Has the player turned over all their cards.
	 */
	public Boolean isTurnOver() {
		for (int intIndex = 0;
		intIndex < this.aryFaceUp.size();
		intIndex++) {
			if (false == this.aryFaceUp.get(intIndex)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Prints the players hand.
	 */
	public void printHand() {
		System.out.println(this.toString());
		for (int intIndex = 0;
		intIndex < this.aryHand.size();
		intIndex++) {
			if (this.aryFaceUp.get(intIndex)) {
				System.out.println(this.aryHand.get(intIndex));
			} else {
				System.out.println(" [ Face Down ]");
			}
		}
	}
	/**
	 * Scores the player and adds it to the current score.
	 */
	public void score() {
		this.intCurrentScore += this.calculateScore();
	}
	/**
     * Method to set the current bet.
     */
	public void setBet(int intpBet) {
		if (intpBet < 0) {
			intpBet = 1;
		}
		if (intpBet > this.getMoney()) {
			intpBet = this.getMoney();
		}
		this.intCurrentBet = intpBet;
	}
	/**
     * Method to set the current money amount the player has.
     */
	public void setMoney(int intpMoney) {
		this.intCurrentMoney = intpMoney;
	}
	/**
     * Set the players name.
     */
	public void setName(String strpName) {
		this.strName = strpName;
	}
	/**
	 * Swaps the card out and returns the card you got by swapping.
	 */
	public Card swapCard(int intpCardIndex, Card objpNewCard) {
		Card objOldCard = this.aryHand.get(intpCardIndex);
		this.aryHand.set(intpCardIndex, objpNewCard);
		this.aryFaceUp.set(intpCardIndex, true);
		return objOldCard;
	}
	/** 
     * Return the player object as a string.
     */
	public String toString() {
		return this.getName() + ": your current score is " + this.getScore() + ", you have $" + this.getMoney() + ", your current bet is $" + this.getBet() + ", " + (this.isTurnOver() ? "and you turn is over.": "and you can still play.");
	}
	/**
	 * Turns over a specific card.
	 */
	public void turnCardOver(int intpCardIndex) {
		this.aryFaceUp.set(intpCardIndex, !this.aryFaceUp.get(intpCardIndex));
	}
}