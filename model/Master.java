package model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

class Master {
    private Board board;

    Master (Board board) {
        this.board = board;
    }

    void shuffle_deck (CardDeck deck2shuffle) {
        Random randgen = new Random(); //to generate random numbers

        Card i_card; //saves the value of the i-th card
        int swap_pos; //saves the position of the card to be swapped with the i-th card

        for (int i = 0; i < deck2shuffle.deck.size(); i++) {
            i_card = deck2shuffle.deck.get(i);
            swap_pos = randgen.nextInt(deck2shuffle.deck.size());

            deck2shuffle.deck.set(i, deck2shuffle.deck.get(swap_pos));
            deck2shuffle.deck.set(swap_pos, i_card);
        }
    }

    void put_cards_in_envelope(Envelope answer_envelope, CardDeck[] all_decks) {
        Card card2put;

        for (int i = 0; i < all_decks.length; i++) {
            card2put = all_decks[i].deck.get(0);
            answer_envelope.content[i] = card2put;
            all_decks[i].deck.remove(0);
        }
    }

    void distribute_cards2players (Player[] players, CardDeck[] all_decks) {
        Card card2put;

        for (int i = 0; i < all_decks.length; i++) { //for each deck
            while (all_decks[i].deck.size() != 0) { //while there are cards in the deck
                for (int j = 0; j < players.length; j++) { //give a card to each players
                    if (all_decks[i].deck.size() == 0) {
                        break;
                    }
                    card2put = all_decks[i].deck.get(0);
                    players[j].insert_card(card2put);
                    all_decks[i].deck.remove(0);
                }
            }
        }
    }

    void distribute_notepads2players (Player[] players, Notepad[] all_notepads) {
        if (players.length != all_notepads.length) { //error
            System.out.println("Error. Number of players does not match number of notepads");
            System.exit(0);
        }
        
        for (int i = 0; i < players.length; i++) {
            players[i].insert_notepad(all_notepads[i]);
        }
    }

    void move_pawn (Pawn player_pawn, int[] dice_roll, int[] new_location) {
        if (is_valid_move(player_pawn.get_location(), dice_roll, new_location)) {
            player_pawn.move(new_location);
        }
    }

    boolean is_valid_move(int[] curr_location, int[] dice_roll, int[] new_location) {
        //Given a pawn located on the board house (i, j)
        //and a dice roll of value n,
        // the pawn can be moved to any house:
        // (i + a, j + b)
        //such that |a| + |b| <= n, and (|a| + |b|) has the same parity of n.

        if (board.get_house_value(new_location) == 1) {
            return false;
        }

        int n = dice_roll[0] + dice_roll[1];
        int a = new_location[0] - curr_location[0];
        int b = new_location[1] - curr_location[1];

        int sum = Math.abs(a) + Math.abs(b);

        if (sum <= n) {
            if (n % 2 == 0) {
                if (sum % 2 == 0) {
                    return true;
                }
            }
            else {
                if (sum % 2 != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    ArrayList<int[]> map_valid_moves(int[] curr_location, int[] dice_roll) {
        ArrayList<int[]> valid_moves = new ArrayList<>();
        
        int n = dice_roll[0] + dice_roll[1];

        int i, j;
        for (i = (curr_location[0] - n); i <= (curr_location[0] + n); i++) {
            if ((i < 0) || (i > 23)) {
                continue;
            }

            for (j = (curr_location[0] - n); j <= (curr_location[0] + n); j++) {
                if ((j < 0) || (j > 24)) {
                    continue;
                }

                if (is_valid_move(curr_location, dice_roll, new int[] {i, j})) {
                    valid_moves.add(new int[] {i, j});
                }
            }
        }

        return valid_moves;
    }

    HashMap create_player_order_list (Player[] active_players) {
        HashMap<Integer, Player> plyr_order = new HashMap<>();

        for (int i = 0; i < active_players.length; i++) {
            if (active_players[i].get_pawn().get_type() == "Srta. Scarlet") {
                plyr_order.put(0, active_players[i]);
            }
            if (active_players[i].get_pawn().get_type() == "Coronel Mustard") {
                plyr_order.put(1, active_players[i]);
            }
            if (active_players[i].get_pawn().get_type() == "Sra. White") {
                plyr_order.put(2, active_players[i]);
            }
            if (active_players[i].get_pawn().get_type() == "Reverendo Green") {
                plyr_order.put(3, active_players[i]);
            }
            if (active_players[i].get_pawn().get_type() == "Sra. Peacock") {
                plyr_order.put(4, active_players[i]);
            }
            if (active_players[i].get_pawn().get_type() == "Professor Plum") {
                plyr_order.put(5, active_players[i]);
            }
        }

        return plyr_order;
    }
}
