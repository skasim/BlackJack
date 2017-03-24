package com.sk.utils;

import com.sk.objects.Dealer;
import com.sk.objects.Hand;
import com.sk.objects.MoneyPot;
import com.sk.objects.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by SamK on 3/22/17.
 */
public class GameUtils {

    /**
     * Method returns the input value entered into the console as a string
     * @return value: String input value entered by user
     *
     * @precondition -- the program will run the method
     * @postcondition -- the method will return a String
     */
    public static String getInput()
    {
        String value;
        Scanner input = new Scanner(System.in);
        value = input.nextLine();
        return value;
    }
    public static double getDoubleInput()
    {
        double value;
        Scanner input = new Scanner(System.in);
        value = input.nextDouble();
        return value;
    }
    public static void printTotals(Player player, Dealer dealer, Hand playerHand, Hand dealerHand){
        System.out.println();
        System.out.println("Game Update:");
        System.out.println("PLAYER'S hand: ["+ playerHand.toString()+"]");
        System.out.println("PLAYER point total ["+ player.getPointTotal()+"]");
        System.out.println("DEALER'S hand ["+ dealerHand.toString()+"]");
        System.out.println("DEALER point total ["+ dealer.getPointTotal()+"]");
        System.out.println();
    }
    public static void determineWinner(int playerPointTotal, int dealerPointTotal, MoneyPot moneyPot,
                                       double currentBet){
        if (dealerPointTotal > playerPointTotal) {
            System.out.println("DEALER WINS with point total of [" + dealerPointTotal + "] " +
                    " versus player point total of [" + playerPointTotal + "]");
            // Subtract currentBet from moneyPot because of loss
            moneyPot.subtractMoney(currentBet);
        } else if (dealerPointTotal < playerPointTotal){
            System.out.println("PLAYER WINS with point total of [" + playerPointTotal + "]" +
                    " versus dealer point total of [" + dealerPointTotal + "]");
            // Add currentBet to moneyPot because of win
            moneyPot.addMoney(currentBet);
        } else {
            System.out.println("PLAYER AND DEALER TIED with a point total of [" + playerPointTotal + "]");
        }
    }
    public static boolean validateContinueGameResponse(MoneyPot moneyPot){
        boolean play = false;
        System.out.println("You have a total of [$"+ moneyPot.getMoney() +"] remaining");
        if (moneyPot.getMoney()<=0){
            System.out.println("Ending Game. You have run out of money");
            play = false;
        } else {
            System.out.println("Play game again? [y]es or [n]o");
            String input = getInput();
            if (input.equals("n")){
                play = false;
            } else if (input.equals("y")){
                play = true;
            } else {
                System.out.println("Invalid response. Try again");
                validateContinueGameResponse(moneyPot);
            }
        }
        return play;
    }
    public static double validateMoneyPotRespone(){
        double inputMoneyPot = -1;
        while (inputMoneyPot <= 0) {
            try {
                System.out.println("How much money would you like to play with today? Input must be" +
                        " greater than 0.");

                inputMoneyPot = getDoubleInput();
            } catch (InputMismatchException e) {
                System.out.println("Invalid format");
                inputMoneyPot = validateMoneyPotRespone();
            }
        }
        return inputMoneyPot;
    }
    public static double validatecurrentBetResponse(double moneyPotAmount){
        double currentBet = -1;
        while (currentBet <= 0 || currentBet > moneyPotAmount) {
            try {
                if (currentBet > moneyPotAmount){
                    System.out.println("You have bet more money than you current have. Invalid bet. " +
                            "Try again");
                    currentBet = getDoubleInput();
                } else {

                    System.out.println("How much money would you like to bet on this game? Input must be" +
                            " greater than 0.");
                    currentBet = getDoubleInput();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid format");
                currentBet = validateMoneyPotRespone();
            }
        }
        return currentBet;
    }
}
