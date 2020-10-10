package ba.unsa.etf.rpr;
public class Pawn extends ChessPiece {
    public Pawn(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public boolean ispravanPotez(String pozicija) {
        int pozicijaI = getPozicijuINaTabli(pozicija.toUpperCase());
        int pozicijaJ = getPozicijuJNaTabli(pozicija.toUpperCase());
        int trenuntnaPozicijaI = getPozicijuINaTabli(getPosition());
        int trenutnaPozicijaJ = getPozicijuJNaTabli(getPosition());
        if (getColor().equals(Color.WHITE)) {
            return ((getPosition().charAt(1) == '2' && (pozicija.charAt(1) == '3' || pozicija.charAt(1) == '4')) && pozicija.charAt(0) == getPosition().charAt(0)) ||
                    (getPosition().charAt(0) == pozicija.charAt(0) && Math.abs(getPosition().charAt(1) - pozicija.charAt(1)) == 1) ||
                    (Math.abs(pozicijaI - trenuntnaPozicijaI) == 1 && Math.abs(pozicijaJ - trenutnaPozicijaJ) == 1);
        }
        return ((getPosition().charAt(1) == '7' && (pozicija.charAt(1) == '6' || pozicija.charAt(1) == '5')) && pozicija.charAt(0) == getPosition().charAt(0)) ||
                (getPosition().charAt(0) == pozicija.charAt(0) && Math.abs(getPosition().charAt(1) - pozicija.charAt(1)) == 1) ||
                (Math.abs(pozicijaI - trenuntnaPozicijaI) == 1 && Math.abs(pozicijaJ - trenutnaPozicijaJ) == 1);
    }
}