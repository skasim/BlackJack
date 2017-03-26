package com.sk.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Class creates a Hand object representing the hand (i.e., all the cards that
 * have been dealt to a participant)
 *
 * @author Samra Kasim
 */
public class Hand
{
    private List<Card> hand;

    /**
     * Constructor creates a new Hand object that contains a List of type Card
     * and the variable cardsCount, which represents the number of cards in the Hand
     */
    public Hand()
    {
        this.hand = new ArrayList<Card>();
    }

    /**
     * Getter method returns the Hand object
     * @return hand: Hand object representing a the hand (i.e., all the cards that
     * have been dealt to a participant)
     */
    public List<Card> getHand()
    {
        return this.hand;
    }

    /**
     * Setter method sets the Hand object
     * @param hand: Hand object representing a the hand (i.e., all the cards that
     * have been dealt to a participant)
     */
    public void setHand(List<Card> hand)
    {
        this.hand = hand;
    }

    /**
     * Method adds a Card object to the Hand object
     * @param card: Card object representing a card in a deck
     */
    public void addtoHand(Card card)
    {
        this.hand.add(card);
    }

    /**
     * Getter method returns the size of the List of type Card
     * @return int: an Integer value representing the number of Card objects in
     * List of type Card
     */
    public int getCardsCount()
    {
        return getHand().size();
    }

    /**
     * toString method that generates a comma separated String of all the key values in the
     * deckOfCards ArrayList
     * @return arrayOutput: String value representing the comma separated String of all the key values in the
     * deckOfCards ArrayList
     */
    public String toString()
    {
        String arrayOutput = "";
        for (int i=0; i<hand.size(); i++)
        {
            if (!(i == hand.size() - 1))
            {
                arrayOutput += hand.get(i).getKey()+", ";
            } else
            {
                arrayOutput += hand.get(i).getKey();
            }
        }
        return arrayOutput;
    }
}
