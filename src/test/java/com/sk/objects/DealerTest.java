package com.sk.objects;

import com.sk.objects.Dealer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SamK on 3/22/17.
 */
public class DealerTest
{
    static int _expectedPointTotal = 50;
    static int _expectedResetPointTotal = 0;

    @Test
    public void setPointTotal() throws Exception
    {
        Dealer dealer = new Dealer();
        dealer.setPointTotal(50);
        assertEquals(_expectedPointTotal, dealer.getPointTotal());
    }

    @Test
    public void addToPointTotal() throws Exception
    {
        Dealer dealer = new Dealer();
        dealer.setPointTotal(40);
        dealer.addToPointTotal(10);
        assertEquals(_expectedPointTotal, dealer.getPointTotal());
    }

    @Test
    public void resetPointTotal() throws Exception
    {
        Dealer dealer = new Dealer();
        dealer.setPointTotal(50);
        dealer.resetPointTotal();
        assertEquals(_expectedResetPointTotal, dealer.getPointTotal());
    }

}