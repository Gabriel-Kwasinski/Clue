package model;

import java.util.HashMap;

class RoomsDeck extends CardDeck {
    RoomsDeck () {
        deck.put(0, new RoomCard("Biblioteca"));
        deck.put(1, new RoomCard("Cozinha"));
        deck.put(2, new RoomCard("Entrada"));
        deck.put(3, new RoomCard("Escritório"));
        deck.put(4, new RoomCard("Jardim de Inverno"));
        deck.put(5, new RoomCard("Sala de Estar"));
        deck.put(6, new RoomCard("Sala de Jantar"));
        deck.put(7, new RoomCard("Sala de Música"));
        deck.put(8, new RoomCard("Salão de Jogos"));
    }
}