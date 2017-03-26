package com.sk.objects;

/**
 * Class creates a Card object, which is a representation of 1 card in a deck of
 * cards

 * @author Samra Kasim
 */
public class Card
{
    private String key;
    private int value;

    /**
     * Constructor takes in String key and integer and creates a new Card object
     * @param key: a String value representing a card (e.g., Two of Spades)
     * @param value: a int value representing the numeric value of a card
     */
    Card(String key, int value){
        this.key = key;
        this.value = value;
    }

    /**
     * Getter method returns the key for the Card object
     * @return key: a String value
     */
    public String getKey()
    {
        return this.key;
    }

    /**
     * Setter method sets the key value for the Card object
     * @param key: a String value representing the key variable
     */
    public void setKey(String key)
    {
        this.key = key;
    }

    /**
     * Getter method returns the value for the Card object
     * @return value: an int value
     */
    public int getValue()
    {
        return this.value;
    }

    /**
     * Setter method sets the Value variable for the Card object
     * @param value: an integer value representing the value of a card
     */
    public void setValue(int value)
    {
        this. value = value;
    }
}
