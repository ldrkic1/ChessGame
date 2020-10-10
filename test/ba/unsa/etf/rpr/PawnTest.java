package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    @Test
    void constructor1() {
        assertDoesNotThrow(
                () -> new Pawn("a7", ChessPiece.Color.BLACK)
        );
    }
    @Test
    void move1() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("E4")
        );
    }
    @Test
    void move2() {
        Pawn p = new Pawn("a7", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> p.move("a5")
        );
    }
    @Test
    void move3() {
        Pawn p = new Pawn("a7", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalChessMoveException.class,
                () -> p.move("a4")
        );
    }


}