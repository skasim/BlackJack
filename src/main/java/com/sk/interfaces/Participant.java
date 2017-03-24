package com.sk.interfaces;

/**
 * Created by SamK on 3/11/17.
 */
public interface Participant
{

    void addToPointTotal(int pointsEarned);

    void resetPointTotal();

    int getPointTotal();
}
