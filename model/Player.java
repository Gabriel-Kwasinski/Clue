package model;

import java.util.ArrayList;

class Player {
    private int id;

    private ArrayList<Card> suspect_ply_cards = new ArrayList<Card>();
    private ArrayList<Card> weapon_ply_cards  = new ArrayList<Card>();
    private ArrayList<Card> room_ply_cards    = new ArrayList<Card>();

    Player (int id) {
        this.id = id;
    }

    int get_id() {
        return this.id;
    }

    void insert_card(Card card) {
        if (card.get_type() == "suspect") {
            this.suspect_ply_cards.add(card);
        }
        else if (card.get_type() == "weapon") {
            this.weapon_ply_cards.add(card);
        }
        else if (card.get_type() == "room") {
            this.room_ply_cards.add(card);
        }
    }

    void print_player_decks() {
        System.out.printf("ID = %d\n", this.id);
        //suspect cards
        System.out.printf("suspect cards = {");
        for (int i = 0; i < this.suspect_ply_cards.size(); i++) {
            System.out.printf("%s ,", this.suspect_ply_cards.get(i).get_value());
        }
        System.out.printf("}\n");
        //weapon cards
        System.out.printf("weapon cards = {");
        for (int i = 0; i < this.weapon_ply_cards.size(); i++) {
            System.out.printf("%s ,", this.weapon_ply_cards.get(i).get_value());
        }
        System.out.printf("}\n");
        //room cards
        System.out.printf("room cards = {");
        for (int i = 0; i < this.room_ply_cards.size(); i++) {
            System.out.printf("%s ,", this.room_ply_cards.get(i).get_value());
        }
        System.out.printf("}\n");
        System.out.printf("\n");
    }
}