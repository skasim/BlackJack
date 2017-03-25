package com.sk.objects;

import com.sk.interfaces.Participant;

/**
 * Class implements the Participant interface and creates a Player object
 *
 * @author Samra Kasim
 */
public class Player implements Participant
{

    private int pointTotal;
    private MoneyPot moneyPot;

    /**
     * Constructor method creates a Player object with pointTotal value set to 0
     * and instantiates a new MoneyPot object
     */
    public Player()
    {
        this.pointTotal = 0;
        this.moneyPot = new MoneyPot();
    }
    /**
     * Getter method returns pointTotal value for the Player object
     * @return pointTotal: int value representing the player's total points
     */
    public int getPointTotal()
    {
        return this.pointTotal;
    }
    /**
     * Setter method sets pointTotal for the Player object
     * @param pointTotal: int value representing the player's total points
     */
    public void setPointTotal(int pointTotal)
    {
        this.pointTotal = pointTotal;
    }

    /**
     * Method adds points to the pointTotal
     * @param pointsEarned An integer value for the number of points earned by participant
     */
    public void addToPointTotal(int pointsEarned)
    {
        int newPointTotal;
        newPointTotal = getPointTotal() + pointsEarned;
        setPointTotal(newPointTotal);
    }

    /**
     * Method resets the pointTotal for the Player object
     */
    public void resetPointTotal() {
        setPointTotal(0);
    }

    /**
     * Method sets the MoneyPot value for the Player object
     * @param moneyPot: MoneyPot object representing player's total money
     */
    public void setMoneyPot(MoneyPot moneyPot) { this.moneyPot = moneyPot;}

    /**
     * Method gets the MoneyPot value for the Player object
     * @return MoneyPot object representing player's total money
     */
    public MoneyPot getMoneyPot() { return this.moneyPot; }

}
