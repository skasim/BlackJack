package com.sk.objects;

import com.sk.objects.Card;
import com.sk.objects.Hand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for Hand class
 *
 * @author Samra Kasim
 */

public class HandTest
{

    private static String _expectedHand = "Two of Spades, Three of Hearts";
    private static String _expectedSecondHand = "Two of Spades, Three of Hearts, Eight of Clubs";
    private static int _expectedLength = 3;
    @Test
    public void handTests() throws Exception
    {
        List<Card> cards = new ArrayList<>(); // instantiated a new List Array of Cards (or Hand)
        Card hitCard = new Card("Two of Spades", 2); // instantiated a new Card
        Card hitCard2 = new Card("Three of Hearts", 3);
        cards.add(hitCard); // added the new Card to the Hand
        cards.add(hitCard2);
        Hand hand = new Hand(); // instantiate a new Hand object
        hand.setHand(cards); // setHand to the Cards Array with the Card I instantiated
        assertEquals(_expectedHand, hand.toString());
        Card hitCard3 = new Card("Eight of Clubs", 8);
        hand.addtoHand(hitCard3);
        assertEquals(_expectedSecondHand, hand.toString());
        assertEquals(_expectedLength, hand.getCardsCount());
    }
}