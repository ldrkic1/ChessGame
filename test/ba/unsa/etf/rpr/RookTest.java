package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    @Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("t9", ChessPiece.Color.WHITE)
        );
    }
    @Test
    void constructor2() {
        assertDoesNotThrow(
                () -> new Rook("F1", ChessPiece.Color.WHITE)
        );
    }
    @Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("aa1", ChessPiece.Color.BLACK)
        );
    }
    @Test
    void move1(){
        Rook r = new Rook("d4", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> r.move("a4")
        );
    }
    @Test
    void move2() {
        Rook r = new Rook("d4", ChessPiece.Color.WHITE);
        assertThrows(
                IllegalChessMoveException.class,
                () -> r.move("e5")
        );
    }
    @Test
    void move3() {
        Rook r = new Rook("d4", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalChessMoveException.class,
                () -> r.move("e8")
        );
    }
    @Test
    void move4() {
        Rook r = new Rook("d4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("D1")
        );
    }
}