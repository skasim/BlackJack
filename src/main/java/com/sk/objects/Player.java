package com.sk.objects;

import com.sk.interfaces.Participant;

/**
 * Created by SamK on 3/12/17.
 */
public class Player implements Participant
{

    private int pointTotal;
    private MoneyPot moneyPot;

    public Player()
    {
        this.pointTotal = 0;
        this.moneyPot = new MoneyPot();
    }

    public int getPointTotal()
    {
        return this.pointTotal;
    }
    public void setPointTotal(int pointTotal)
    {
        this.pointTotal = pointTotal;
    }
    public void addToPointTotal(int pointsEarned)
    {
        int newPointTotal;
        newPointTotal = getPointTotal() + pointsEarned;
        setPointTotal(newPointTotal);
    }
    public void resetPointTotal() {
        setPointTotal(0);
    }
    public void setMoneyPot(MoneyPot moneyPot) { this.moneyPot = moneyPot;}
    public MoneyPot getMoneyPot() { return this.moneyPot; }

}
