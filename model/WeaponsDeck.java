package model;

import java.util.HashMap;

class WeaponsDeck extends CardDeck {
    WeaponsDeck () {
        deck.put(0, new WeaponCard("Cano de Chumbo"));
        deck.put(1, new WeaponCard("Castiçal"));
        deck.put(2, new WeaponCard("Chave Inglesa"));
        deck.put(3, new WeaponCard("Corda"));
        deck.put(4, new WeaponCard("Faca"));
        deck.put(5, new WeaponCard("Revólver"));
    }
}