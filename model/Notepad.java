package model;

import java.util.ArrayList;
import java.util.HashMap;

class Notepad {
    HashMap<String, HashMap> notepad = new HashMap<>();

    HashMap<String, Boolean> suspect_block = new HashMap<>();
    HashMap<String, Boolean> weapon_block  = new HashMap<>();
    HashMap<String, Boolean> room_block    = new HashMap<>();

    Notepad () {
        suspect_block.put("Reverendo Green", false);
        suspect_block.put("Coronel Mustard", false);
        suspect_block.put("Sra. Peacock", false);
        suspect_block.put("Professor Plum", false);
        suspect_block.put("Srta. Scarlet", false);
        suspect_block.put("Sra. White", false);

        weapon_block.put("Cano de Chumbo", false);
        weapon_block.put("Castiçal", false);
        weapon_block.put("Chave Inglesa", false);
        weapon_block.put("Corda", false);
        weapon_block.put("Faca", false);
        weapon_block.put("Revólver", false);

        room_block.put("Biblioteca", false);
        room_block.put("Cozinha", false);
        room_block.put("Entrada", false);
        room_block.put("Escritório", false);
        room_block.put("Jardim de Inverno", false);
        room_block.put("Sala de Estar", false);
        room_block.put("Sala de Jantar", false);
        room_block.put("Sala de Música", false);
        room_block.put("Salão de Jogos", false);

        notepad.put("suspects", suspect_block);
        notepad.put("weapons", weapon_block);
        notepad.put("rooms", room_block);
    }

    void print_notepad() {
        for (HashMap.Entry<String, HashMap> entry : this.notepad.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
            System.out.printf("\n");
        }
    }

    void check_notepad (String block, String item, boolean bool) {
        this.notepad.get(block).replace(item, bool);
    }
}