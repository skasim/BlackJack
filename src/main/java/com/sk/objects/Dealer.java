package com.sk.objects;

import com.sk.interfaces.Participant;

/**
 * Created by SamK on 3/12/17.
 */
public class Dealer implements Participant {

    private int pointTotal;

    public Dealer(){
        this.pointTotal = 0;
    }
    public int getPointTotal()
    {
        return this.pointTotal;
    }
    public void setPointTotal(int pointTotal)
    {
        this.pointTotal = pointTotal;
    }
    public void addToPointTotal(int pointsEarned) {
        int newPointTotal;
        newPointTotal = getPointTotal() + pointsEarned;
        setPointTotal(newPointTotal);
    }
    public void resetPointTotal() {
        setPointTotal(0);
    }
}
