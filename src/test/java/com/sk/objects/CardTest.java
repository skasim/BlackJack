package com.sk.objects;

import com.sk.objects.Card;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for Card class
 *
 * @author Samra Kasim
 */
public class CardTest
{

    static String _expectedKey = "testKey";
    static int _expectedValue = 1;
    static int _expectedResetValue = 100;

    @Test
    public void testCardObject() throws Exception
    {
        Card card = new Card("testKey", 1);
        assertEquals(_expectedKey, card.getKey());
        assertEquals(_expectedValue, card.getValue(), 0);
        card.setValue(100);
        assertEquals(_expectedResetValue, card.getValue(), 0);
    }

}