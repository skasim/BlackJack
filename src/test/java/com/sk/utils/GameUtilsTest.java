package com.sk.utils;

import com.sk.objects.Dealer;
import com.sk.objects.MoneyPot;
import com.sk.objects.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Unit tests for GameUtils class
 *
 * @author Samra Kasim
 */
public class GameUtilsTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static String _expectedDetermineWinnerPlayerWinsResponse = "PLAYER WINS with point total of [19] " +
            "versus dealer point total of [17]\n";
    private static String _expectedDetermineWinnerDealerWinsResponse = "DEALER WINS with point total of [21]  " +
            "versus player point total of [10]\n";
    private static String _expectedDetermineTieResponse = "PLAYER AND DEALER TIED with a point total of [20]\n";

    @Before
    public void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams()
    {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void determineWinnerPlayerWins() throws Exception
    {
        Player player = new Player();
        MoneyPot moneyPot = new MoneyPot();
        Dealer dealer = new Dealer();
        dealer.setPointTotal(17);
        player.setPointTotal(19);
        double currentBet = 10;
        GameUtils.determineWinner(player.getPointTotal(), dealer.getPointTotal(),
        moneyPot, currentBet);
        assertEquals(_expectedDetermineWinnerPlayerWinsResponse, outContent.toString());
    }

    @Test
    public void determineWinnerDealerWins() throws Exception
    {
        Player player = new Player();
        MoneyPot moneyPot = new MoneyPot();
        Dealer dealer = new Dealer();
        dealer.setPointTotal(21);
        player.setPointTotal(10);
        double currentBet = 10;
        GameUtils.determineWinner(player.getPointTotal(), dealer.getPointTotal(),
                moneyPot, currentBet);
        assertEquals(_expectedDetermineWinnerDealerWinsResponse, outContent.toString());
    }
    @Test
    public void determineWinnerTie() throws Exception
    {
        Player player = new Player();
        MoneyPot moneyPot = new MoneyPot();
        Dealer dealer = new Dealer();
        dealer.setPointTotal(20);
        player.setPointTotal(20);
        double currentBet = 10;
        GameUtils.determineWinner(player.getPointTotal(), dealer.getPointTotal(),
                moneyPot, currentBet);
        assertEquals(_expectedDetermineTieResponse, outContent.toString());
    }
}