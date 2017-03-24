package com.sk.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SamK on 3/16/17.
 */
public class Hand {
    private List<Card> hand;
    private int cardsCount;

    public Hand(){
        this.hand = new ArrayList<Card>();
        this.cardsCount = 0;
    }

    public List<Card> getHand(){ return this.hand; }
    public void setHand(List<Card> hand) { this.hand = hand; }
    public void addtoHand(Card card) { this.hand.add(card); }
    public int getCardsCount() { return getHand().size(); }
    public void setCardsCount(int cardsCount) { this.cardsCount = cardsCount; }
    public void addToCardsCount(){ this.cardsCount +=1; }
    public String toString(){
        String arrayOutput = "";
        for (int i=0; i<hand.size(); i++){
            if (!(i == hand.size() - 1)){
                arrayOutput += hand.get(i).getKey()+", ";
            } else {
                arrayOutput += hand.get(i).getKey();
            }
        }
        return arrayOutput;
    }
}
