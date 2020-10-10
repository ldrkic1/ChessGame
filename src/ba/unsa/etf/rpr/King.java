package ba.unsa.etf.rpr;

public class King extends ChessPiece {
        public King(String pozicija, Color boja) {
            super(pozicija,boja);
        }

        @Override
        public boolean ispravanPotez(String pozicija) {
            int trenutnaPozicijaI = getPozicijuINaTabli(getPosition());
            int trenutnaPozicijaJ = getPozicijuJNaTabli(getPosition());
            int pozicijaI = getPozicijuINaTabli(pozicija.toUpperCase());
            int pozicijaJ = getPozicijuJNaTabli(pozicija.toUpperCase());
            return (Math.abs(pozicijaI-trenutnaPozicijaI) == 1 && pozicijaJ==trenutnaPozicijaJ) || (Math.abs(pozicijaJ-trenutnaPozicijaJ) == 1 && trenutnaPozicijaI == pozicijaI)
                    || (Math.abs(pozicijaI-trenutnaPozicijaI) == 1 && Math.abs(pozicijaJ-trenutnaPozicijaJ)==1);
        }
}
