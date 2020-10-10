package ba.unsa.etf.rpr;
public class Knight extends ChessPiece {
    public Knight(String pozicija, Color boja) {
        super(pozicija, boja);
    }

    @Override
    public boolean ispravanPotez(String pozicija) {
        int trenutnaPozicijaI = getPozicijuINaTabli(getPosition());
        int trenutnaPozicijaJ = getPozicijuJNaTabli(getPosition());
        int pozicijaI = getPozicijuINaTabli(pozicija.toUpperCase());
        int pozicijaJ = getPozicijuJNaTabli(pozicija.toUpperCase());
        return (Math.abs(trenutnaPozicijaI - pozicijaI) == 1 && Math.abs(trenutnaPozicijaJ - pozicijaJ) == 2) || (Math.abs(trenutnaPozicijaI - pozicijaI) == 2 && Math.abs(trenutnaPozicijaJ - pozicijaJ) == 1);
    }
}
