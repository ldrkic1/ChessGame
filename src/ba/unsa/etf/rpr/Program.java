package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Program {
     public static void main(String[] args) {
    	Board board = new Board();
         Scanner ulaz = new Scanner(System.in);
         try {
             for (; ;) {
                 System.out.println("White move: ");
                 String potezWhite = ulaz.next();
                 ulaz.skip("\n");
                 if (potezWhite.charAt(0) == 'K') {
                     board.move(King.class, ChessPiece.Color.WHITE, potezWhite.substring(1));
                 }
                 else if (potezWhite.charAt(0) == 'Q') {
                     board.move(Queen.class, ChessPiece.Color.WHITE, potezWhite.substring(1));
                 }
                 else if (potezWhite.charAt(0) == 'R') {
                     board.move(Rook.class, ChessPiece.Color.WHITE, potezWhite.substring(1));
                 }
                 else if (potezWhite.charAt(0) == 'B') {
                     board.move(Bishop.class, ChessPiece.Color.WHITE, potezWhite.substring(1));
                 }
                 else if (potezWhite.charAt(0) == 'N') {
                     board.move(Knight.class, ChessPiece.Color.WHITE, potezWhite.substring(1));
                 }
                 else if(potezWhite.length() == 2) {
                     board.move(Pawn.class, ChessPiece.Color.WHITE, potezWhite);
                 }
                 else if (potezWhite.charAt(0) == 'X' && potezWhite.length() == 1) {
                     break;
                 }
                 else {
                     throw new IllegalArgumentException("Greska!!");
                 }

                 System.out.println("Black move: ");
                 String potezBlack = ulaz.next();
                 ulaz.skip("\n");

                 if (potezBlack.charAt(0) == 'K') {
                     board.move(King.class, ChessPiece.Color.BLACK, potezBlack.substring(1));
                 }
                 else if (potezBlack.charAt(0) == 'Q') {
                     board.move(Queen.class, ChessPiece.Color.BLACK, potezBlack.substring(1));
                 }
                 else if (potezBlack.charAt(0) == 'R') {
                     board.move(Rook.class, ChessPiece.Color.BLACK, potezBlack.substring(1));
                 }
                 else if (potezBlack.charAt(0) == 'B') {
                     board.move(Bishop.class, ChessPiece.Color.BLACK, potezBlack.substring(1));
                 }
                 else if (potezBlack.charAt(0) == 'N') {
                     board.move(Knight.class, ChessPiece.Color.BLACK, potezBlack.substring(1));
                 }
                 else if (potezBlack.length() == 2) {
                     board.move(Pawn.class, ChessPiece.Color.BLACK, potezBlack);
                 }
                 else if (potezBlack.charAt(0) == 'X' && potezBlack.length() == 1) {
                     break;
                 }
                 else {
                     throw new IllegalArgumentException("Greska!!");
                 }

                 if (board.isCheck(ChessPiece.Color.BLACK) || board.isCheck(ChessPiece.Color.WHITE)) {
                     System.out.println("CHECK!!!");
                     break;
                 }
             }
         }
         catch (Exception e) {
             e.getMessage();
         }
    }
}