package model;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class ModelTest {

    @Test
    public void dadoDeveRetornarValoresEntre1e6() {
        Player player = new Player(0);

        for (int i = 0; i < 100; i++) {
            int[] dados = player.throw_dice();

            assertTrue(dados[0] >= 1 && dados[0] <= 6);
            assertTrue(dados[1] >= 1 && dados[1] <= 6);
        }
    }

    @Test
    public void envelopeDeveReceberUmaCartaDeCadaDeck() {
        SuspectsDeck suspectsDeck = new SuspectsDeck();
        WeaponsDeck weaponsDeck = new WeaponsDeck();
        RoomsDeck roomsDeck = new RoomsDeck();

        CardDeck[] allDecks = {suspectsDeck, weaponsDeck, roomsDeck};

        Envelope envelope = new Envelope();
        Master master = new Master(new Board());

        master.put_cards_in_envelope(envelope, allDecks);

        assertNotNull(envelope.content[0]);
        assertNotNull(envelope.content[1]);
        assertNotNull(envelope.content[2]);

        assertEquals("suspect", envelope.content[0].get_type());
        assertEquals("weapon", envelope.content[1].get_type());
        assertEquals("room", envelope.content[2].get_type());
    }

    @Test
    public void decksDevemPerderUmaCartaDepoisDoEnvelope() {
        SuspectsDeck suspectsDeck = new SuspectsDeck();
        WeaponsDeck weaponsDeck = new WeaponsDeck();
        RoomsDeck roomsDeck = new RoomsDeck();

        CardDeck[] allDecks = {suspectsDeck, weaponsDeck, roomsDeck};

        Envelope envelope = new Envelope();
        Master master = new Master(new Board());

        master.put_cards_in_envelope(envelope, allDecks);

        assertEquals(5, suspectsDeck.get_deck().size());
        assertEquals(5, weaponsDeck.get_deck().size());
        assertEquals(8, roomsDeck.get_deck().size());
    }

    @Test
    public void cartasRestantesDevemSerDistribuidasAosJogadores() {
        SuspectsDeck suspectsDeck = new SuspectsDeck();
        WeaponsDeck weaponsDeck = new WeaponsDeck();
        RoomsDeck roomsDeck = new RoomsDeck();

        CardDeck[] allDecks = {suspectsDeck, weaponsDeck, roomsDeck};

        Envelope envelope = new Envelope();
        Master master = new Master(new Board());

        master.put_cards_in_envelope(envelope, allDecks);

        Player[] players = {
            new Player(0),
            new Player(1),
            new Player(2)
        };

        master.distribute_cards2players(players, allDecks);

        assertEquals(0, suspectsDeck.get_deck().size());
        assertEquals(0, weaponsDeck.get_deck().size());
        assertEquals(0, roomsDeck.get_deck().size());
    }

    @Test
    public void notepadDeveMarcarItemComoTrue() {
        Notepad notepad = new Notepad();

        notepad.check_notepad("suspects", "Coronel Mustard", true);

        assertEquals(true, notepad.suspect_block.get("Coronel Mustard"));
    }

    @Test
    public void peaoDeveMoverParaNovaLocalizacao() {
        Pawn pawn = new Pawn("Srta. Scarlet", new int[] {24, 7});

        pawn.move(new int[] {23, 7});

        assertEquals(23, pawn.get_location()[0]);
        assertEquals(7, pawn.get_location()[1]);
    }

    @Test
    public void movimentoValidoDeveRetornarTrue() {
        Board board = new Board();
        Master master = new Master(board);

        int[] atual = {24, 7};
        int[] dados = {1, 1};
        int[] destino = {22, 7};

        assertTrue(master.is_valid_move(atual, dados, destino));
    }

    @Test
    public void movimentoParaCasaBloqueadaDeveRetornarFalse() {
        Board board = new Board();
        Master master = new Master(board);

        int[] atual = {24, 7};
        int[] dados = {1, 1};
        int[] destinoBloqueado = {23, 1};

        assertFalse(master.is_valid_move(atual, dados, destinoBloqueado));
    }

    @Test
    public void mapValidMovesDeveRetornarListaNaoVazia() {
        Board board = new Board();
        Master master = new Master(board);

        int[] atual = {24, 7};
        int[] dados = {1, 1};

        ArrayList<int[]> movimentos = master.map_valid_moves(atual, dados);

        assertNotNull(movimentos);
        assertTrue(movimentos.size() > 0);
    }

    @Test
    public void ordemDosJogadoresDeveColocarScarletPrimeiro() {
        Player p1 = new Player(0);
        Player p2 = new Player(1);
        Player p3 = new Player(2);

        p1.insert_pawn(new Pawn("Coronel Mustard", new int[] {17, 0}));
        p2.insert_pawn(new Pawn("Srta. Scarlet", new int[] {24, 7}));
        p3.insert_pawn(new Pawn("Professor Plum", new int[] {19, 23}));

        Player[] players = {p1, p2, p3};

        Master master = new Master(new Board());

        HashMap<Integer, Player> ordem = master.create_player_order_list(players);

        assertEquals(p2, ordem.get(0));
    }
}