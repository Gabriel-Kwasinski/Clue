package model;

class Card {
    protected String type;
    protected String value;

    Card (String type, String value) {
        this.type  = type;
        this.value = value;
    }

    String get_value() {
        return this.value;
    }

    String get_type() {
        return this.type;
    }

}