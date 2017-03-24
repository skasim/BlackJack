package com.sk.objects;

import com.sk.objects.MoneyPot;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SamK on 3/11/17.
 */
public class MoneyPotTest {

    @Test
    public void MoneyPotTest() throws Exception {
        MoneyPot moneyPot = new MoneyPot(50);
        assertEquals(50, moneyPot.getMoney(),0 );
        moneyPot.setMoney(110);
        assertEquals(110, moneyPot.getMoney(), 0);
        moneyPot.addMoney(50);
        assertEquals(160, moneyPot.getMoney(), 0);
        moneyPot.subtractMoney(30);
        assertEquals(130, moneyPot.getMoney(), 0);
    }

}