package com.sk.objects;

import com.sk.interfaces.Participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by SamK on 3/9/17.
 */
public class Deck {
    private ArrayList<Card> deckOfCards = new ArrayList<Card>();
    private ArrayList<String> acesList = new ArrayList<>();

    public Deck(){
        deckOfCards.add(new Card("Two of Spades", 2));
        deckOfCards.add(new Card("Two of Diamonds", 2));
        deckOfCards.add(new Card("Two of Hearts", 2));
        deckOfCards.add(new Card("Two of Clubs", 2));
        deckOfCards.add(new Card("Three of Spades", 3));
        deckOfCards.add(new Card("Three of Diamonds", 3));
        deckOfCards.add(new Card("Three of Hearts", 3));
        deckOfCards.add(new Card("Three of Clubs", 3));
        deckOfCards.add(new Card("Four of Spades", 4));
        deckOfCards.add(new Card("Four of Diamonds", 4));
        deckOfCards.add(new Card("Four of Hearts", 4));
        deckOfCards.add(new Card("Four of Clubs", 4));
        deckOfCards.add(new Card("Five of Spades", 5));
        deckOfCards.add(new Card("Five of Diamonds", 5));
        deckOfCards.add(new Card("Five of Hearts", 5));
        deckOfCards.add(new Card("Five of Clubs", 5));
        deckOfCards.add(new Card("Six of Spades", 6));
        deckOfCards.add(new Card("Six of Diamonds", 6));
        deckOfCards.add(new Card("Six of Hearts", 6));
        deckOfCards.add(new Card("Six of Clubs", 6));
        deckOfCards.add(new Card("Seven of Spades", 7));
        deckOfCards.add(new Card("Seven of Diamonds", 7));
        deckOfCards.add(new Card("Seven of Hearts", 7));
        deckOfCards.add(new Card("Seven of Clubs", 7));
        deckOfCards.add(new Card("Eight of Spades", 8));
        deckOfCards.add(new Card("Eight of Diamonds", 8));
        deckOfCards.add(new Card("Eight of Hearts", 8));
        deckOfCards.add(new Card("Eight of Clubs", 8));
        deckOfCards.add(new Card("Nine of Spades", 9));
        deckOfCards.add(new Card("Nine of Diamonds", 9));
        deckOfCards.add(new Card("Nine of Hearts", 9));
        deckOfCards.add(new Card("Nine of Clubs", 9));
        deckOfCards.add(new Card("Ten of Spades", 10));
        deckOfCards.add(new Card("Ten of Diamonds", 10));
        deckOfCards.add(new Card("Ten of Hearts", 10));
        deckOfCards.add(new Card("Ten of Clubs", 10));
        deckOfCards.add(new Card("Jack of Spades", 10));
        deckOfCards.add(new Card("Jack of Diamonds", 10));
        deckOfCards.add(new Card("Jack of Hearts", 10));
        deckOfCards.add(new Card("Jack of Clubs", 10));
        deckOfCards.add(new Card("Queen of Spades", 10));
        deckOfCards.add(new Card("Queen of Diamonds", 10));
        deckOfCards.add(new Card("Queen of Hearts", 10));
        deckOfCards.add(new Card("Queen of Clubs", 10));
        deckOfCards.add(new Card("King of Spades", 10));
        deckOfCards.add(new Card("King of Diamonds", 10));
        deckOfCards.add(new Card("King of Hearts", 10));
        deckOfCards.add(new Card("King of Clubs", 10));
        deckOfCards.add(new Card("Ace of Spades", 1));
        deckOfCards.add(new Card("Ace of Diamonds", 1));
        deckOfCards.add(new Card("Ace of Hearts", 1));
        deckOfCards.add(new Card("Ace of Clubs", 1));
        acesList.addAll(Arrays.asList("Ace of Spades", "Ace of Diamonds", "Ace of Hearts", "Ace of Clubs"));
    }


    public Card takeHit(Deck deck, Participant participant){
        int randomUpperBound = deck.getCards().size();
        //System.out.println("random upper bound: "+ randomUpperBound);
        Random random = new Random();

        int r = random.nextInt(randomUpperBound); // +1 because the bound is exclusive
        Card card = deckOfCards.get(r); //there is something not right here where you are getting index out of bound exceptions

        /* Check to see if card is an ace (in acesList). If it is, then check point total to see if
        adding 11 would exceed 21, if point total doesn't exceed 21, then set ace to 11. If point total
        does exceed 21, then set ace to 1.
         */
        if (acesList.contains(card.getKey())){
            if((participant.getPointTotal()+11)<=21){
                card.setValue(11);
            } else{
                card.setValue(1);
            }
        }
        //remove card from array/deck
        deckOfCards.remove(r);
        //return card value
        return card;
    }
    public ArrayList<Card> getCards(){
        //System.out.println(deckOfCards.size());
        return this.deckOfCards;
    }
    public String toString(){
        String str ="";
        for (int i=0; i<deckOfCards.size(); i++){
            if (!(i == (deckOfCards.size() -1))){
                str += deckOfCards.get(i).getKey() +", ";
            } else {
                str += deckOfCards.get(i).getKey();
            }

        }
        return str;
    }
}
