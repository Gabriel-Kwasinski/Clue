package model;

import java.util.HashMap;

class SuspectsDeck extends CardDeck {
    SuspectsDeck () {
        deck.put(0, new SuspectCard("Reverendo Green"));
        deck.put(1, new SuspectCard("Coronel Mustard"));
        deck.put(2, new SuspectCard("Sra. Peacock"));
        deck.put(3, new SuspectCard("Professor Plum"));
        deck.put(4, new SuspectCard("Srta. Scarlet"));
        deck.put(5, new SuspectCard("Sra. White"));
    }
}