package com.sk.objects;

import com.sk.objects.MoneyPot;
import com.sk.objects.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Player class
 *
 * @author Samra Kasim
 */
public class PlayerTest
{
    @Test
    public void testMoneyPot() throws Exception
    {

        Player player = new Player();
        MoneyPot moneyPot = new MoneyPot(100);
        player.setMoneyPot(moneyPot);
        assertEquals(100, player.getMoneyPot().getMoney(),0.0);
    }

    @Test
    public void addToPointTotal() throws Exception
    {
        Player player = new Player();
        player.setPointTotal(99);
        player.addToPointTotal(100);
        assertEquals(199, player.getPointTotal());
    }

}