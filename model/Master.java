package model;

import java.util.HashMap;
import java.util.Random;

class Master {
    void shuffle_deck (CardDeck deck2shuffle) {
        Random randgen = new Random();

        Card i_card; //saves the value of the i-th card
        int swap_pos; //saves the position of the card to be swapped with the i-th card

        for (int i = 0; i < deck2shuffle.deck.size(); i++) {
            i_card = deck2shuffle.deck.get(i);
            swap_pos = randgen.nextInt(deck2shuffle.deck.size());

            deck2shuffle.deck.replace(i, deck2shuffle.deck.get(swap_pos));
            deck2shuffle.deck.replace(swap_pos, i_card);
        }
    }

    void put_cards_in_envelope(Envelope answer_envelope, CardDeck[] decks) {
        Card card2put;

        for (int i = 0; i < decks.length; i++) {
            card2put = decks[i].deck.get(0);
            answer_envelope.content[i] = card2put;
            decks[i].deck.remove(0);
        }
    }
}