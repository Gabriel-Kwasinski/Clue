package model;

import java.util.HashMap;

class RoomsDeck extends CardDeck {
    RoomsDeck () {
        deck.add(new RoomCard("Biblioteca"));
        deck.add(new RoomCard("Cozinha"));
        deck.add(new RoomCard("Entrada"));
        deck.add(new RoomCard("Escritório"));
        deck.add(new RoomCard("Jardim de Inverno"));
        deck.add(new RoomCard("Sala de Estar"));
        deck.add(new RoomCard("Sala de Jantar"));
        deck.add(new RoomCard("Sala de Música"));
        deck.add(new RoomCard("Salão de Jogos"));
    }
}