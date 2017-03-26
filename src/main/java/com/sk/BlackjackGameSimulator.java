package com.sk;

import com.sk.objects.*;
import com.sk.utils.GameUtils;


/**
 * Console game that demonstrates use of objects, classes, interface, unit tests, and java to simulate
 * a Black Jack game
 *
 * @author Samra Kasim
 */
public class BlackjackGameSimulator
{
    /**
     * Console-game entry point. The main class instantiates Player, Dealer, MoneyPot, Hand, and Deck objects
     * and contains the logic of the game.
     * @param args: String values supplied when running console game
     */
    public static void main(String[] args)
    {

        MoneyPot moneyPot = new MoneyPot(); // Create player's moneyPot
        moneyPot.setMoney(GameUtils.validateMoneyPotResponse()); // Ask player how much money they have to play today
        Player player = new Player(); // Create a new player
        Dealer dealer = new Dealer(); // Create a new dealer

        // Start a game
        boolean play = true;

        while (play)
        {
            // Reset point totals for dealer and player to 0
            player.resetPointTotal();
            dealer.resetPointTotal();
            System.out.println("STARTING A NEW GAME!");
            System.out.println();
            // Ask player how much money they want to bet this hand
            double currentBet = GameUtils.validateCurrentBetResponse(moneyPot.getMoney());

            // Create a new deck, playerHand, and dealerHand
            Deck deck = new Deck();
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();

            // Player gets dealt 2 cards facing up
            Card pcard1 = deck.takeHit(deck, player);
            playerHand.addtoHand(pcard1);
            Card pcard2 = deck.takeHit(deck, player);
            playerHand.addtoHand(pcard2);
            player.addToPointTotal(pcard1.getValue() + pcard2.getValue());
            System.out.println("PLAYER is dealt cards [" + pcard1.getKey() + " and " + pcard2.getKey() + "] " +
                    "valued at [" + (pcard1.getValue() + pcard2.getValue()) + "]");

            // If the 2 cards dealt to player equal 21. Player wins
            if ((pcard1.getValue() + pcard2.getValue()) == 21)
            {
                System.out.println("PLAYER WINS with point total [" + player.getPointTotal() + "]");
                // Add currentBet to moneyPot because of win
                moneyPot.addMoney(currentBet);
                GameUtils.playerWinsBet(currentBet, moneyPot);
                //TODO REMOVE BELOW
                GameUtils.printTotals(player, dealer, playerHand, dealerHand);
            }
            // If player did not win with 21 right off the bat
            else
                {
                //Dealer gets dealt 2 cards, 1 face up and 1 face down
                Card dcard1 = deck.takeHit(deck, dealer);
                dealerHand.addtoHand(dcard1);
                Card dcard2 = deck.takeHit(deck, dealer);
                dealerHand.addtoHand(dcard2);
                dealer.addToPointTotal(dcard1.getValue() + dcard2.getValue());
                System.out.println("DEALER is dealt two cards. Card facing up is [" + dcard1.getKey()+"] " +
                        "valued at [" + dcard1.getValue() +"]");
                //TODO REMOVE BELOW
                System.out.println("REMOVE LATER: Dealer point total is: " + dealer.getPointTotal());

                // Player can now determine whether she wants to hit or stay
                boolean hit = true;
                do
                    {
                    System.out.println("PLAYER, [h]it or [s]tay");
                    String input = GameUtils.getInput();
                    if (input.equals("h"))
                    {
                        // If player wants to hit
                        Card pcard = deck.takeHit(deck, player);
                        playerHand.addtoHand(pcard);
                        player.addToPointTotal(pcard.getValue());
                        System.out.println("PLAYER chooses to hit. Card is [" + pcard.getKey()+"]");
                        //TODO REMOVE BELOW
                        GameUtils.printTotals(player, dealer, playerHand, dealerHand);
                        // With every hit taken, check to see if score exceeds 21
                        if (player.getPointTotal() > 21)
                        {
                            // If score exceeds 21 player automatically loses
                            System.out.println("DEALER WINS with point total of [" + dealer.getPointTotal()
                                    +"] versus PLAYER point total of [" + player.getPointTotal() + "]");
                            // Subtract currentBet from moneyPot because of loss
                            moneyPot.subtractMoney(currentBet);
                            GameUtils.playerLosesBet(currentBet, moneyPot);
                            hit = false;
                        }
                        else if (player.getPointTotal() == 21)
                        {
                            System.out.println("PLAYER WINS with point total of [" + player.getPointTotal() + "] " +
                                    "versus DEALER point total of [" + dealer.getPointTotal() + "]");
                            hit = false;
                            // Add currentBet to moneyPot because of win
                            moneyPot.addMoney(currentBet);
                            GameUtils.playerWinsBet(currentBet, moneyPot);
                        }
                    }
                    else if (input.equals("s"))
                    {
                        hit = false;
                        System.out.println("PLAYER chooses to stay");
                        //TODO REMOVE BELOW
                        GameUtils.printTotals(player, dealer, playerHand, dealerHand);

                    }
                    else
                    {
                        System.out.println("Invalid input. Try again.");
                    }
                }
                while (hit);

                // If player has not won then the dealer takes automatic hits until point total is over 16
                if (player.getPointTotal() < 21)
                {
                    if (dealer.getPointTotal() < 17)
                    {
                        while (dealer.getPointTotal() < 17)
                        {
                            Card dcard = deck.takeHit(deck, dealer);
                            dealerHand.addtoHand(dcard);
                            dealer.addToPointTotal(dcard.getValue());
                            System.out.println("DEALER takes automatic hit. Card is [" +  dcard.getKey()
                            + "] valued at [" + dcard.getValue() + "]");
                            if (dealer.getPointTotal() > 21)
                            {
                                System.out.println("PLAYER WINS with point total of [" + player.getPointTotal() + "]" +
                                        " versus DEALER point total of [" + dealer.getPointTotal() + "]");
                                // Add currentBet to moneyPot because of win
                                moneyPot.addMoney(currentBet);
                                GameUtils.playerWinsBet(currentBet, moneyPot);
                                //TODO REMOVE BELOW
                                GameUtils.printTotals(player, dealer, playerHand, dealerHand);
                                break;
                            }
                            else if (dealer.getPointTotal() == 21)
                            {
                                System.out.println("DEALER WINS with point total of ["+ dealer.getPointTotal()
                                        +"] versus PLAYER point total of [" + player.getPointTotal() + "]");
                                // Subtract currentBet from moneyPot because of loss
                                moneyPot.subtractMoney(currentBet);
                                GameUtils.playerLosesBet(currentBet, moneyPot);
                                //TODO REMOVE BELOW
                                GameUtils.printTotals(player, dealer, playerHand, dealerHand);
                                break;
                            }
                            else if (dealer.getPointTotal() >= 17 && dealer.getPointTotal() > player.getPointTotal())
                            {
                                GameUtils.determineWinner(player.getPointTotal(), dealer.getPointTotal(),
                                        moneyPot, currentBet);
                                //TODO REMOVE BELOW
                                GameUtils.printTotals(player, dealer, playerHand, dealerHand);
                                break;
                            }
                            else if (dealer.getPointTotal() >= 17 && dealer.getPointTotal() > player.getPointTotal())
                            {
                                GameUtils.determineWinner(player.getPointTotal(), dealer.getPointTotal(),
                                        moneyPot, currentBet);
                                //TODO REMOVE BELOW
                                GameUtils.printTotals(player, dealer, playerHand, dealerHand);
                                break;
                            }
                        }
                    }
                    else
                    {
                        GameUtils.determineWinner(player.getPointTotal(), dealer.getPointTotal(),
                                moneyPot, currentBet);
                    }
                }
            }
            // If player runs out of money, end game. Else, ask if they want to continue or end game
            play = GameUtils.validateContinueGameResponse(moneyPot);
        }
    }
}
