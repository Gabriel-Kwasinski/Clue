package model;

class Pawn {
    private String type;
    private int[] location;

    Pawn (String type, int[] location) {
        this.type = type;
        this.location = location;
    }

    String get_type () {
        return this.type;
    }

    int[] get_location () {
        return this.location;
    }

    void move (int[] new_location) { //moves pawn to new board house
        this.location[0] = new_location[0];
        this.location[1] = new_location[1];
    }
}