package model;

import java.util.ArrayList;
import java.util.Random;

class Player {
    private int id;

    private ArrayList<Card> suspect_ply_cards = new ArrayList<Card>();
    private ArrayList<Card> weapon_ply_cards  = new ArrayList<Card>();
    private ArrayList<Card> room_ply_cards    = new ArrayList<Card>();

    private Notepad player_notepad;

    private Pawn player_pawn;

    Player (int id) {
        this.id = id;
    }

    int get_id() {
        return this.id;
    }

    void insert_card (Card card) {
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

    void insert_notepad (Notepad ntpd) {
        this.player_notepad = ntpd;
    }

    void check_notepad (String block, String item, Boolean bool) {
        this.player_notepad.check_notepad(block, item, bool);
    }

    void insert_pawn (Pawn pawn) {
        this.player_pawn = pawn;
    }

    void print_pawn () {
        System.out.println(this.player_pawn.get_type());
    }

    int[] throw_dice () {
        Random randgen = new Random();
        int[] dice_values = {randgen.nextInt(6) + 1, randgen.nextInt(6) + 1};
        return dice_values;
    }

    void request2move_pawn(int[] new_location, int[] dice_roll, Master master) {
        master.move_pawn(this.player_pawn, dice_roll, new_location);
    }

    void print_player_decks () {
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

    void print_notepad () {
        this.player_notepad.print_notepad();
    }
}