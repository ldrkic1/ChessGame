package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void move1() {
        Knight k = new Knight("e4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("f6")
        );
    }

    @Test
    void move2() {
        Knight k = new Knight("f3", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("h2")
        );
    }

    @Test
    void move3() {
        Knight k = new Knight("f3", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("E1")
        );
    }

    @Test
    void move4() {
        Knight k = new Knight("e4", ChessPiece.Color.WHITE);
        assertThrows(
                IllegalChessMoveException.class,
                () -> k.move("D1")
        );
    }

    @Test
    void move5() {
        Knight k = new Knight("f3", ChessPiece.Color.WHITE);
        assertThrows(
                IllegalChessMoveException.class,
                () -> k.move("c3")
        );
    }



    @Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Knight("Q3", ChessPiece.Color.BLACK)
        );
    }

    @Test
    void constructor2() {
        assertDoesNotThrow(
                () -> new Knight("G8", ChessPiece.Color.BLACK)
        );
    }



    @Test
    void getColor1() {
        Knight k = new Knight("G8", ChessPiece.Color.BLACK);
        assertNotEquals(ChessPiece.Color.WHITE, k.getColor());
    }

}
