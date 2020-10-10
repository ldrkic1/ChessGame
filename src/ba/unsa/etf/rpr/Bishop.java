package ba.unsa.etf.rpr;
public class Bishop extends ChessPiece {
    public Bishop(String pozicija, Color boja)  {
        super(pozicija, boja);
    }
    @Override
    public boolean ispravanPotez(String pozicija) {
        int pozicijaI = getPozicijuINaTabli(pozicija.toUpperCase());
        int pozicijaJ = getPozicijuJNaTabli(pozicija.toUpperCase());
        String trenutnaPozicija = getPosition();
        int trenutnaI = getPozicijuINaTabli(trenutnaPozicija);
        int trenutnaJ = getPozicijuJNaTabli(trenutnaPozicija);
        return  ((trenutnaI + trenutnaJ) == (pozicijaI + pozicijaJ) || ((trenutnaI - trenutnaJ) == (pozicijaI - pozicijaJ)));
    }
}