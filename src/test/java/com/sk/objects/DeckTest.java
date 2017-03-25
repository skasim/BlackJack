package com.sk.objects;

import com.sk.objects.Deck;
import com.sk.objects.Hand;
import com.sk.objects.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SamK on 3/9/17.
 */
public class DeckTest
{
    String _expectedDeck = "Two of Spades, Two of Diamonds, Two of Hearts, Two of Clubs, Three of Spades, " +
            "Three of Diamonds, Three of Hearts, Three of Clubs, " +
            "Four of Spades, Four of Diamonds, Four of Hearts, " +
            "Four of Clubs, Five of Spades, Five of Diamonds, " +
            "Five of Hearts, Five of Clubs, Six of Spades, " +
            "Six of Diamonds, Six of Hearts, Six of Clubs, " +
            "Seven of Spades, Seven of Diamonds, Seven of Hearts, " +
            "Seven of Clubs, Eight of Spades, Eight of Diamonds, " +
            "Eight of Hearts, Eight of Clubs, Nine of Spades, " +
            "Nine of Diamonds, Nine of Hearts, Nine of Clubs, " +
            "Ten of Spades, Ten of Diamonds, Ten of Hearts, Ten of Clubs, " +
            "Jack of Spades, Jack of Diamonds, Jack of Hearts, Jack of Clubs, " +
            "Queen of Spades, Queen of Diamonds, Queen of Hearts, Queen of Clubs," +
            " King of Spades, King of Diamonds, King of Hearts, King of Clubs, Ace of Spades, " +
            "Ace of Diamonds, Ace of Hearts, Ace of Clubs";
    @Test
    public void TakeHitTest() throws Exception
    {
        Deck deck = new Deck();
        Hand hand = new Hand();
        Player player = new Player();
        player.setPointTotal(2);
        assertNotNull(deck.takeHit(deck, player));
    }
    @Test
    public void getCardsTest() throws Exception
    {
        Deck deck = new Deck();
        assertEquals(_expectedDeck, deck.toString());
    }
}