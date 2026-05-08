package model;

import java.util.ArrayList;
import java.util.HashMap;

class SuspectsDeck extends CardDeck {
    SuspectsDeck () {
        deck.add(new SuspectCard("Reverendo Green"));
        deck.add(new SuspectCard("Coronel Mustard"));
        deck.add(new SuspectCard("Sra. Peacock"));
        deck.add(new SuspectCard("Professor Plum"));
        deck.add(new SuspectCard("Srta. Scarlet"));
        deck.add(new SuspectCard("Sra. White"));
    }
}