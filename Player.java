/**
 * Player Class for Golf Game
 * @author Chris M
 * @version 1.0
 */

import java.util.Scanner;

public class Player {

    static int intNumberOfPlayers = 1;
    String strName = "No One";
    int intCurrentMoney = 100;
    int intCurrentBet = 10;
    //Array Hand

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
        this.intCurrentBet = intpBet;
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
        Scanner objScanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        this.setName(objScanner.nextLine());
    }

    /* 
     * Return the player object as a string.
     */
    public String toString() {
        return this.getName() + ": you have $" +
            this.getMoney() + " and your current bet is $" +
            this.getBet() + ".";
    }
}