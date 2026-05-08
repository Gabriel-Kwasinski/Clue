package model;

import java.util.HashMap;

class WeaponsDeck extends CardDeck {
    WeaponsDeck () {
        deck.add(new WeaponCard("Cano de Chumbo"));
        deck.add(new WeaponCard("Castiçal"));
        deck.add(new WeaponCard("Chave Inglesa"));
        deck.add(new WeaponCard("Corda"));
        deck.add(new WeaponCard("Faca"));
        deck.add(new WeaponCard("Revólver"));
    }
}