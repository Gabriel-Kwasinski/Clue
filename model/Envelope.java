package model;

class Envelope {
    Card[] content = new Card[3];

    void print_content() {
        System.out.printf("{");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s, ", content[i].value);
        }
        System.out.printf("}\n");
    }
}