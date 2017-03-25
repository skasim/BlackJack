package com.sk.objects;

/**
 * Class creates a MoneyPot objects, which represents the total amount of money that a Player object can
 * play with during a session
 *
 * @author Samra Kasim
 */
public class MoneyPot
{
    private double money;

    /**
     * Constructor creates a moneyPot object, with money variable set to 0.0
     */
    public MoneyPot()
    {
        this.money = 0.0;
    }

    /**
     * Constructor takes in a the amount of money for the MoneyPot variable and creates a MoneyPot
     * object
     * @param money: a double value representing the total amount of money for a Player object
     */
    public MoneyPot(double money)
    {
        this.money = money;
    }

    /**
     * Getter method returns the money variable for the MoneyPot object
     * @return money: double value representing the total amount of money for a Player object
     */
    public double getMoney()
    {
        return this.money;
    }

    /**
     * Setter method sets the money variable value for the MoneyPot object
     * @param money: double value representing the total amount of money for a Player object
     */
    public void setMoney(double money)
    {
        this.money = money;
    }

    /**
     * Method adds money to the money variable of the MoneyPot object
     * @param money: double value representing the total amount of money for a Player object
     */
    public void addMoney(double money)
    {
        this.money += money;
    }

    /**
     * Method subtracts money from the money variable of the MoneyPot object
     * @param money: double value representing the total amount of money for a Player object
     */
    public void subtractMoney(double money)
    {
        this.money -= money;
    }
}
