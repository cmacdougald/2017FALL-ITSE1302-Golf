/**
 * Card Class for Golf Game
 * @author Chris M
 * @version 1.0
 */
import java.util.Scanner;
public class Card {
    /**
     * Main demo for card class.
     */
    public static void main(String [] strArg) {
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Please enter a number between 1 and 52: ");
        int intCard = objScanner.nextInt();
        int intFace = ((intCard - 1) % 13) + 1;
        int intSuite = (intCard - 1) / 13;

        System.out.println("Card: " + intCard);
        System.out.println("Face: " + intFace);
        System.out.println("Suite: " + intSuite);
    }
}