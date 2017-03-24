package com.sk.objects;

/**
 * Created by SamK on 3/11/17.
 */
public class MoneyPot {

    private double money;

    public MoneyPot(){
        this.money = 0.0;
    }

    MoneyPot(double money){
        this.money = money;
    }

    public double getMoney(){ return this.money; }
    public void setMoney(double money){ this.money = money; };
    public void addMoney(double money){ this.money += money; }
    public void subtractMoney(double money){ this.money -= money; }
}
