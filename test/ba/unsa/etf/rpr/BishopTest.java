package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    void move1()  {

        Bishop b = new Bishop("E4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () ->  b.move("A8")
        );
    }
    @Test
    void move2() {
        Bishop b = new Bishop("e4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("h7")
        );
    }
    @Test
    void move3() {
        Bishop b = new Bishop("h6", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("f4")
        );
    }
    @Test
    void move4() {
        Bishop b = new Bishop("e4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () ->  b.move("b1")
        );
    }
    @Test
    void moveIllegal1() {
        Bishop b = new Bishop("b2", ChessPiece.Color.WHITE);
        assertThrows(
                IllegalChessMoveException.class,
                () -> b.move("h7")
        );
    }
    @Test
    void moveIllegal2() {
        Bishop b = new Bishop("c8", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalChessMoveException.class,
                () -> b.move("h1")
        );
    }
    @Test
    void constructor1() {
        assertDoesNotThrow(
                () -> new Bishop("f8", ChessPiece.Color.BLACK)
        );
    }
    @Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("K1", ChessPiece.Color.BLACK)
        );
    }
    @Test
    void getColor1() {
        Bishop b = new Bishop("c8", ChessPiece.Color.BLACK);
        assertEquals(ChessPiece.Color.BLACK, b.getColor());
    }
    @Test
    void getColor2() {
        Bishop b = new Bishop("c1", ChessPiece.Color.WHITE);
        assertNotEquals(ChessPiece.Color.BLACK, b.getColor());
    }
}