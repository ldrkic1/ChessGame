package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    // Is the board usable after isCheck
    void someLegalMoves() {
        Board b = new Board();

        boolean no = b.isCheck(ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> {

                    b.move(Pawn.class, ChessPiece.Color.WHITE, "E4");
                    b.move(Bishop.class, ChessPiece.Color.WHITE, "A6");
                    b.move(Knight.class, ChessPiece.Color.WHITE, "C3");
                    b.move(King.class, ChessPiece.Color.WHITE, "E2");
                    b.move(King.class, ChessPiece.Color.WHITE, "E3");
                }
        );
    }

    @Test
    // Pawn eats diagonally
    void pawnDiagonal() {
        Board b = new Board();
        assertDoesNotThrow(
            () -> {
                b.move(Pawn.class, ChessPiece.Color.WHITE, "E4");
                b.move(Pawn.class, ChessPiece.Color.WHITE, "E5");
                b.move(Pawn.class, ChessPiece.Color.WHITE, "E6");
                b.move(Pawn.class, ChessPiece.Color.WHITE, "D7");
                b.move(Pawn.class, ChessPiece.Color.WHITE, "C8");
            }
        );
    }

    @Test
    // Check by pawn
    void isCheck() {
        Board b = new Board();
        try {
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E4");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E5");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E6");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "D7");
        } catch(Exception e) {
            // Do nothing
        }
        assertTrue(b.isCheck(ChessPiece.Color.BLACK));
    }

    @Test
    // Will queen be moved by isCheck
    void isCheckUsable() {
        Board b = new Board();
        try {
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E4");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E5");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E6");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "D7");
            //b.move(Queen.class, ChessPiece.Color.WHITE, "E2");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "F4");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "F5");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "F6");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E7");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "F8");
        } catch(Exception e) {
            // Do nothing
        }
        b.isCheck(ChessPiece.Color.BLACK);
        assertDoesNotThrow(
            () -> {
                b.move(Queen.class, ChessPiece.Color.WHITE, "D3");
            }
        );
    }

    @Test
    // No check
    void isCheck2() {
        Board b = new Board();
        try {
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E4");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E5");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E6");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "D7");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "C8");
            b.move(Queen.class, ChessPiece.Color.WHITE, "E2");
        } catch(Exception e) {
            // Do nothing
        }
        assertFalse(b.isCheck(ChessPiece.Color.BLACK));
    }

    @Test
    // Check by queen
    void isCheck3() {
        Board b = new Board();
        try {
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E4");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E5");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E6");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "D7");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "C8");
            b.move(Queen.class, ChessPiece.Color.WHITE, "E2");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "F4");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "F5");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "F6");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "E7");
            b.move(Pawn.class, ChessPiece.Color.WHITE, "F8");
        } catch(Exception e) {
            // Do nothing
        }
        assertTrue(b.isCheck(ChessPiece.Color.BLACK));
    }

    @Test
    // Queen, bishop and rook can't jump pieces
    void jumpPiece() {
        Board b = new Board();
        assertAll(
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move(Rook.class, ChessPiece.Color.BLACK, "H6")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move(Bishop.class, ChessPiece.Color.BLACK, "H6")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move(Queen.class, ChessPiece.Color.BLACK, "A5")
                )
        );
    }


    // Same test with other move method

    @Test
    // Is the board usable after isCheck
    void someLegalMoves1() {
        Board b = new Board();
        boolean no = b.isCheck(ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> {
                    b.move("E2", "E4");
                    b.move("F1", "A6");
                    b.move("B1", "C3");
                    b.move("E1", "E2");
                    b.move("E2", "E3");
                }
        );
    }

    @Test
    // Pawn eats diagonally, check by queen
    void pawnDiagonal1() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("E2", "E4");
                    b.move("E4", "E5");
                    b.move("E5", "E6");
                    b.move("E6", "D7");
                    b.move("D7", "C8");
                }
        );
    }

    @Test
    // Check by pawn
    void isCheck1() {
        Board b = new Board();
        try {
            b.move("E2", "E4");
            b.move("E4", "E5");
            b.move("E5", "E6");
            b.move("E6", "D7");
        } catch(Exception e) {
            // Do nothing
        }
        assertTrue(b.isCheck(ChessPiece.Color.BLACK));
    }

    @Test
    // No check
    void isCheck12() {
        Board b = new Board();
        try {
            b.move("E2", "E4");
            b.move("E4", "E5");
            b.move("E5", "E6");
            b.move("E6", "D7");
            b.move("D7", "C8");
            b.move("D1", "E2");
        } catch(Exception e) {
            // Do nothing
        }
        assertFalse(b.isCheck(ChessPiece.Color.BLACK));
    }

    @Test
    // Check by queen
    void isCheck13() {
        Board b = new Board();
        try {
            b.move("E2", "E4");
            b.move("E4", "E5");
            b.move("E5", "E6");
            b.move("E6", "D7");
            b.move("D7", "C8");
            b.move("D1", "E2");
            b.move("F2", "F4");
            b.move("F4", "F5");
            b.move("F5", "F6");
            b.move("F6", "E7");
            b.move("E7", "F8");
        } catch(Exception e) {
            // Do nothing
        }
        assertTrue(b.isCheck(ChessPiece.Color.BLACK));
    }

    @Test
    // Queen, bishop and rook can't jump pieces
    void jumpPiece1() {
        Board b = new Board();
        assertAll(
                () -> assertThrows(

                        IllegalChessMoveException.class,
                        () -> b.move("H8", "H6")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move("F8", "H6")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move("D8", "A5")
                )
        );
    }

    @Test
    // Check by queen
    void isCheckUsable1() {
        Board b = new Board();
        try {
            b.move("E2", "E4");
            b.move("E4", "E5");
            b.move("E5", "E6");
            b.move("E6", "D7");
            b.move("D7", "C8");
            b.move("D1", "E2");
        } catch(Exception e) {
            // Do nothing
        }
        b.isCheck(ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> {
                    b.move("E2", "D3");
                }
        );
    }
    @Test
    void jumpRook1() {
        Board b = new Board();
        assertAll(
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move(Rook.class, ChessPiece.Color.WHITE,"a4")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move(Rook.class, ChessPiece.Color.WHITE, "h5")
                )
        );
    }
    @Test
    void jumpRook2() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("h7","h5");
                    b.move("h5","h4");
                    b.move("h4","h3");
                    b.move("h8","h6");
                }
        );
    }
    @Test
    void jumpRook3() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("h7","h5");
                    b.move("h5","h4");
                    b.move("h4","h3");
                    b.move("h8","h5");
                }
        );
    }
    @Test
    void jumpRook4() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("h7","h5");
                    b.move("h5","h4");
                    b.move("h4","h3");
                    b.move("h8","h5");
                    b.move("h5","a5");
                }
        );
    }
    @Test
    void jumpRook5() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("h7","h5");
                    b.move("h5","h4");
                    b.move("h4","h3");
                    b.move("h8","h5");
                    b.move("h5","a5");
                    b.move("a5","c5");
                }
        );
    }
    @Test
    void jumpRook6() {
        Board b = new Board();
        assertAll(
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move(Rook.class, ChessPiece.Color.BLACK,"a3")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> {
                            b.move("h7","h6");
                            b.move("f7","f6");
                            b.move("h8","h7");
                            b.move("h7","f7");
                        }
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> {
                            b.move("a7","a6");
                            b.move("c7","c6");
                            b.move("a8","a7");
                            b.move("a7","c7");
                        }
                )
        );
    }
    @Test
    void jumpBishop1() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("d2","d4");
                    b.move("c1","g5");
                }
        );
    }
    @Test
    void jumpBishop2() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("d2","d4");
                    b.move("c1","g5");
                    b.move("g5","f6");
                }
        );
    }
    @Test
    void jumpBishop3() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("e2","e4");
                    b.move("f1","e2");
                }
        );
    }
    @Test
    void jumpBishop4() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("e2","e4");
                    b.move("f1","e2");
                    b.move("e2","h5");
                }
        );
    }
    @Test
    void jumpBishop5() {
        Board b = new Board();
        assertThrows(
                IllegalChessMoveException.class,
                () -> {
                    b.move("e2","e4");
                    b.move("f1","e2");
                    b.move("e2","h5");
                    b.move("h5","e8");
                }
        );
    }
    @Test
    void jumpBishop6() {
        Board b = new Board();
        assertThrows(
                IllegalChessMoveException.class,
                () -> b.move("f8","a3")
        );
    }
    @Test
    void jumpBishop7() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("b7","b5");
                    b.move("c8","b7");
                    b.move("b7","e4");
                }
        );
    }
    @Test
    void jumpBishop8() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("e7","e5");
                    b.move("f8","b4");
                    b.move("b4","d2");
                }
        );
    }
    @Test
    void jumpBishop9() {
        Board b = new Board();
        assertAll(
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () ->  b.move("f1","c4")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () ->  b.move("f1","h3")
                )
        );
    }
    @Test
    void isCheck9() {
        Board b = new Board();
        try {
            b.move("e2","e4");
            b.move("f1","e2");
            b.move("e2","h5");
            b.move("h5","f7");
            assertTrue(b.isCheck(ChessPiece.Color.BLACK));
        }
        catch (Exception e) {

        }
    }
    @Test
    void jumpQueen1() {
        Board b = new Board();
        assertAll(
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move("d1","d4")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move("d1","b3")
                )
        );
    }
    @Test
    void jumpQueen2() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("d7","d5");
                    b.move("d8","d6");
                }
        );
    }
    @Test
    void jumpQueen3() {
        Board b = new Board();
        assertAll(
                () -> assertDoesNotThrow(
                        () -> {
                            b.move("d7","d5");
                            b.move("d8","d6");
                            b.move("d6","g3");
                        }
                ),
                () -> assertDoesNotThrow(
                        () -> {
                            b.move("d2","d3");
                            b.move("e2","e3");
                            b.move("d1","h5");
                        }
                ),
                () -> assertDoesNotThrow(
                        () -> {
                            b.move("h5","h3");
                            b.move("h3","e6");
                        }
                )
        );
    }
    @Test
    void jumpQueen4() {
        Board b = new Board();
        assertAll(
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move("d8","h4")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> {
                            b.move("d2","d3");
                            b.move("e2","e3");
                            b.move("g2","g4");
                            b.move("d1","h5");
                        }
                )
        );
    }
    @Test
    void jumpQueen5() {
        Board b = new Board();
        assertAll(
                () -> assertDoesNotThrow(
                        () ->  {
                            b.move("c2","c4");
                            b.move("c4","c5");
                            b.move("d1","b3");
                        }
                )
        );
    }
    @Test
    void jumpQueen6() {
        Board b = new Board();
        assertDoesNotThrow(
                () ->  {
                    b.move("c2","c4");
                    b.move("c4","c5");
                    b.move("d1","b3");
                    b.move("b3","f3");
                    b.move("f3","f5");
                    b.move("f5","d5");
                }
        );
    }
    @Test
    void jumpQueen7() {
        Board b = new Board();
        assertThrows(
                IllegalChessMoveException.class,
                () -> {
                    b.move("e2","e3");
                    b.move("e3","e4");
                    b.move("e4","e5");
                    b.move("d1","h5");
                    b.move("h5","d5");
                }
        );
    }
    @Test
    void isCheck10() {
        Board b = new Board();
        try {
            b.move("d7","d6");
            b.move("e7","e6");
            b.move("f7","f6");
            b.move("b7","b6");
            b.move("c8","b7");
            b.move("b7","c6");
            b.move("b8","a6");
            b.move("a8","c8");
            b.move("g8","h6");
            b.move("h8","f8");
            b.move("e2","e4");
            b.move("e4","e5");
            assertFalse(b.isCheck(ChessPiece.Color.BLACK));
        }
        catch (Exception e) {

        }
    }
}