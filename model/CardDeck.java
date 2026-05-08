package model;

import java.util.ArrayList;
import java.util.HashMap;

class CardDeck {
    protected ArrayList<Card> deck = new  ArrayList<Card>();

    ArrayList<Card> get_deck() {
        return this.deck;
    }

    void print_content() {
        System.out.printf("{");
        for (int i = 0; i < deck.size(); i++) {
            System.out.printf("[%d] = %s, ", i, deck.get(i).get_value());
        }
        System.out.printf("}\n");
    }
}