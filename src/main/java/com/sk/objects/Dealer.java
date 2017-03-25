package com.sk.objects;

import com.sk.interfaces.Participant;

/**
 * Class implements the Participant interface and creates a Dealer object
 *
 * @author Samra Kasim
 */
public class Dealer implements Participant
{
    private int pointTotal;

    /**
     * Constructor method creates a Dealer object with pointTotal value set to 0
     */
    public Dealer()
    {
        this.pointTotal = 0;
    }

    /**
     * Getter method returns pointTotal value for the Dealer object
     * @return pointTotal: int value representing the dealer's total points
     */
    public int getPointTotal()
    {
        return this.pointTotal;
    }

    /**
     * Setter method sets pointTotal for the Dealer object
     * @param pointTotal: int value representing the dealer's total points
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
     * Method resets the pointTotal to 0
     */
    public void resetPointTotal()
    {
        setPointTotal(0);
    }
}
