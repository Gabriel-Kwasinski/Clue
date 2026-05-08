package model;

import java.util.HashMap;

class CardDeck {
    protected HashMap<Integer, Card> deck = new HashMap<>();

    HashMap<Integer, Card> get_deck() {
        return this.deck;
    }

    void print_content() {
        System.out.printf("{");
        for (HashMap.Entry<Integer, Card> entry : deck.entrySet()) {
            System.out.printf("[%d] = %s, ", entry.getKey(), entry.getValue().value);
        }
        System.out.printf("}\n");
    }
}