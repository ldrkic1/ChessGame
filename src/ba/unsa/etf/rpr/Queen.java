package ba.unsa.etf.rpr;
public class Queen extends ChessPiece {
    public Queen(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public boolean ispravanPotez(String pozicija) {
        int pozicijaI = getPozicijuINaTabli(pozicija.toUpperCase());
        int pozicijaJ = getPozicijuJNaTabli(pozicija.toUpperCase());
        int trenutnaPozicijaI = getPozicijuINaTabli(getPosition());
        int trenutnaPozicijaJ = getPozicijuJNaTabli(getPosition());
        return (pozicijaI == trenutnaPozicijaI) || (pozicijaJ == trenutnaPozicijaJ) || (pozicijaI + pozicijaJ == trenutnaPozicijaI + trenutnaPozicijaJ) || (pozicijaI - pozicijaJ == trenutnaPozicijaI - trenutnaPozicijaJ);
    }
}