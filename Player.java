/**
 * Player Class for Golf Game
 * @author Chris M
 * @version 1.0
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Player {

	Scanner objScanner = new Scanner(System. in );
	static int intNumberOfPlayers = 1;
	String strName = "No One";
	int intCurrentMoney = 100;
	int intCurrentBet = 10;
	//Array Hand
	ArrayList < Card > aryHand = new ArrayList < Card > ();
	ArrayList < Boolean > aryFaceUp = new ArrayList < Boolean > ();

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
     * Method to set the current money amount the player has.
     */
	public void setMoney(int intpMoney) {
		this.intCurrentMoney = intpMoney;
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

	public void inputBet() {
		System.out.print(this.getName() + " you have $" + this.getMoney() + " how much would you like to bet? ");
		this.setBet(objScanner.nextInt());
	}

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

	public int getScore() {
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

	/*
     * Get the players name.
     */
	public String getName() {
		return this.strName;
	}

	/*
     * Get the players current money.
     */
	public int getMoney() {
		return this.intCurrentMoney;
	}

	/**
     * Get the players current bet.
     */
	public int getBet() {
		return this.intCurrentBet;
	}

	/*
     * Set the players name.
     */
	public void setName(String strpName) {
		this.strName = strpName;
	}

	/*
     * Prompt the player for the name.
     */
	public void inputName() {
		System.out.print("Please enter your name: ");
		this.setName(objScanner.nextLine());
	}

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

	public void turnCardOver(int intpCardIndex) {
		this.aryFaceUp.set(intpCardIndex, !this.aryFaceUp.get(intpCardIndex));
	}

	public Boolean addCard(Card objpCard) {
		return this.addCard(objpCard, false);
	}

	public Boolean addCard(Card objpCard, Boolean boolFaceUp) {
		if (this.aryHand.size() < 6) {
			this.aryHand.add(objpCard);
			this.aryFaceUp.add(boolFaceUp);
			return true;
		}
		return false;
	}

	public Card swapCard(int intpCardIndex, Card objpNewCard) {
		Card objOldCard = this.aryHand.get(intpCardIndex);
		this.aryHand.set(intpCardIndex, objpNewCard);
		this.aryFaceUp.set(intpCardIndex, true);
		return objOldCard;
	}

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

	public void clearHand() {
		this.aryHand.clear();
		this.aryFaceUp.clear();
	}
	/* 
     * Return the player object as a string.
     */
	public String toString() {
		return this.getName() + ": your current score is " + this.getScore() + ", you have $" + this.getMoney() + ", your current bet is $" + this.getBet() + ", " + (this.isTurnOver() ? "and you turn is over.": "and you can still play.");
	}
}