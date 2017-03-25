package com.sk.utils;

import com.sk.objects.Dealer;
import com.sk.objects.Hand;
import com.sk.objects.MoneyPot;
import com.sk.objects.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Utility class contains method used in execution of the program
 *
 * @author Samra Kasim
 */
public class GameUtils
{

    /**
     * Method returns the input value entered into the console as a string
     * @return value: String input value entered by user
     */
    public static String getInput()
    {
        String value;
        Scanner input = new Scanner(System.in);
        value = input.nextLine();
        return value;
    }

    /**
     * Method returns the input value into the console as a double
     * @return value: double input value entered by user
     */
    public static double getDoubleInput()
    {
        double value;
        Scanner input = new Scanner(System.in);
        value = input.nextDouble();
        return value;
    }

    /**
     * Method prints scores to the console screen
     * @param player: Player object representing the player
     * @param dealer: Dealer object representing the dealer
     * @param playerHand: Hand object representing the player's hand
     * @param dealerHand: Hand object representing the dealer's hand
     */
    public static void printTotals(Player player, Dealer dealer, Hand playerHand, Hand dealerHand)
    {
        System.out.println();
        System.out.println("Game Update:");
        System.out.println("PLAYER'S hand: ["+ playerHand.toString()+"]");
        System.out.println("PLAYER point total ["+ player.getPointTotal()+"]");
        System.out.println("DEALER'S hand ["+ dealerHand.toString()+"]");
        System.out.println("DEALER point total ["+ dealer.getPointTotal()+"]");
        System.out.println();
    }

    /**
     * Method takes in player and dealer point totals, moneyPot value, and currentBet and returns a system.out
     * to the console screen indicating the winner of the game
     * @param playerPointTotal: int value representing the pointTotal in a Player object
     * @param dealerPointTotal: int value representing the pointTotal in a Dealer object
     * @param moneyPot: MoneyPot object representing player's total amount of money
     * @param currentBet: double value representing a player's current bet
     */
    public static void determineWinner(int playerPointTotal, int dealerPointTotal, MoneyPot moneyPot,
                                       double currentBet)
    {
        if (dealerPointTotal > playerPointTotal)
        {
            System.out.println("DEALER WINS with point total of [" + dealerPointTotal + "] " +
                    " versus player point total of [" + playerPointTotal + "]");
            // Subtract currentBet from moneyPot because of loss
            moneyPot.subtractMoney(currentBet);
            playerLosesBet(currentBet, moneyPot);
        }
        else if (dealerPointTotal < playerPointTotal){
            System.out.println("PLAYER WINS with point total of [" + playerPointTotal + "]" +
                    " versus dealer point total of [" + dealerPointTotal + "]");
            // Add currentBet to moneyPot because of win
            moneyPot.addMoney(currentBet);
            playerWinsBet(currentBet, moneyPot);
        }
        else
        {
            System.out.println("PLAYER AND DEALER TIED with a point total of [" + playerPointTotal + "]");
        }
    }

    /**
     * Method asks for and validates the user's response to continue playing game. Method takes in a moneyPot
     * variables representing a moneyPot object.
     * @param moneyPot: variable represnting the MoneyPot object
     * @return play: boolean value representing whether to continue with the game (true) or quit game game(false)
     */
    public static boolean validateContinueGameResponse(MoneyPot moneyPot)
    {
        boolean play = false;
        System.out.println("You have a total of [$"+ moneyPot.getMoney() +"] remaining");
        if (moneyPot.getMoney()<=0)
        {
            System.out.println("Ending Game. You have run out of money");
            play = false;
        }
        else
            {
            System.out.println("Play game again? [y]es or [n]o");
            String input = getInput();
            if (input.equals("n"))
            {
                play = false;
            }
            else if (input.equals("y"))
            {
                play = true;
            }
            else
            {
                System.out.println("Invalid response. Try again");
                validateContinueGameResponse(moneyPot);
            }
        }
        return play;
    }

    /**
     * Method asks for and validates the amount of money for a player to play with in the current game session.
     * @return inputMoneyPot: double value representing the amount of money a player wants to play with
     * in one game sessio
     */
    public static double validateMoneyPotResponse()
    {
        double inputMoneyPot = -1;
        while (inputMoneyPot <= 0)
        {
            try
            {
                System.out.println("How much money would you like to play with today? Input must be" +
                        " greater than 0.");

                inputMoneyPot = getDoubleInput();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid format");
                inputMoneyPot = validateMoneyPotResponse();
            }
        }
        return inputMoneyPot;
    }

    /**
     * Method asks for and validates the amount of money the player wants to bet on the current hand
     * @param moneyPotAmount: double value representing the amount total money a player has
     * @return currentBet: double value representing the current bet placed by player
     */
    public static double validatecurrentBetResponse(double moneyPotAmount)
    {
        double currentBet = -1;
        while (currentBet <= 0 || currentBet > moneyPotAmount)
        {
            try
            {
                if (currentBet > moneyPotAmount)
                {
                    System.out.println("You have bet more money than you current have. Invalid bet. " +
                            "Try again");
                    currentBet = getDoubleInput();
                } else
                {

                    System.out.println("How much money would you like to bet on this game? Input must be" +
                            " greater than 0.");
                    currentBet = getDoubleInput();
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid format");
                currentBet = validateMoneyPotResponse();
            }
        }
        return currentBet;
    }

    /**
     * Method prints a system.out to console screen to indicate the amount of money a player has won
     * and the amount remaining in the MoneyPot
     * @param currentBet: double value representing player's current bet
     * @param moneyPot: double value representing player's overall amount of money
     */
    public static void playerWinsBet(double currentBet, MoneyPot moneyPot){
        System.out.println("PLAYER WINS [$" + currentBet + "] and has a total of " +
                "[$" + moneyPot.getMoney() +"] left to play");
    }

    /**
     * Method prints a system.out to console screen to indicate the amount of money a player has lost
     * and the amount remaining in the MoneyPot
     * @param currentBet: double value representing player's current bet
     * @param moneyPot: double value representing player's overall amount of money
     */
    public static void playerLosesBet(double currentBet, MoneyPot moneyPot){
        System.out.println("PLAYER LOSES [$" + currentBet + "] and has a total of " +
                "[$" + moneyPot.getMoney() +"] left to play");
    }
}
