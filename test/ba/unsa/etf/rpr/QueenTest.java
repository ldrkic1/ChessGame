package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    @Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("I2", ChessPiece.Color.WHITE)
        );
    }
    @Test
    void constructor2() {
        assertDoesNotThrow(
                () -> new Queen("d1", ChessPiece.Color.WHITE)
        );
    }
    @Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("dz", ChessPiece.Color.BLACK)
        );
    }
    @Test
    void move1() {
        Queen q = new Queen("d1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> q.move("d6")
        );
    }
    @Test
    void move2() {
        Queen q = new Queen("d1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> q.move("h1")
        );
    }
    @Test
    void move3() {
        Queen q = new Queen("d1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> q.move("a4")
        );
    }
    @Test
    void move4() {
        Queen q = new Queen("d8", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalChessMoveException.class,
                () -> q.move("e5")
        );
    }
    @Test
    void move5() {
        Queen q = new Queen("d8", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> q.move("d7")
        );
    }
    @Test
    void ispravanPotez1() {
        Queen q = new Queen("d1", ChessPiece.Color.WHITE);
        assertTrue(q.ispravanPotez("f3"));

    }
    @Test
    void ispravanPotez2() {
        Queen q = new Queen("d1", ChessPiece.Color.WHITE);
        assertTrue(q.ispravanPotez("d3"));

    }
    @Test
    void ispravanPotez3() {
        Queen q = new Queen("d1", ChessPiece.Color.WHITE);
        assertFalse(q.ispravanPotez("e3"));

    }




}