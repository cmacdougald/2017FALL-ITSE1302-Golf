/**
 * Player Class for Golf Game
 * @author Chris M
 * @version 1.0
 */

import java.util.Scanner;

public class Player {

    String strName = "No One";
    int intCurrentMoney = 100;
    int intCurrentBet = 10;
    //Array Hand

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