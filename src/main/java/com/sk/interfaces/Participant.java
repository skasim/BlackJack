package com.sk.interfaces;

/**
 * Interface class Participant is implemented by Player and Dealer classes.
 * It requres implementation of methods to add points to total points, reset
 * totoal points, and get total points
 *
 * @author Samra Kasim
 */
public interface Participant
{
    /**
     * Method takes in integer value for number of points earned
     * @param pointsEarned An integer value for the number of points earned by participant
     */
    void addToPointTotal(int pointsEarned);

    /**
     * Method resets the pointTotal to 0
     */
    void resetPointTotal();

    /**
     * Method returns the integer point total value for a participant
     * @return integer value for pointTotal
     */
    int getPointTotal();
}
