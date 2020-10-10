package ba.unsa.etf.rpr;
abstract class ChessPiece {
    public enum Color {BLACK, WHITE}
    private String pozicija;
    private Color boja;

    public ChessPiece(String pozicija, Color boja) {
        if(!ispravnaPozicija(pozicija)) {
            throw new IllegalArgumentException("Neispravan pozicija");
        }
        this.pozicija = pozicija.toUpperCase();
        this.boja = boja;
    }

    public static boolean ispravnaPozicija(String p) {
        if(p.length()<=1) return false;
        p=p.toUpperCase();
        if((p.charAt(0) >= 'A' && p.charAt(0) <= 'H' && p.charAt(1) >= '1' && p.charAt(1) <= '8') || p.equals("??")) {
            return true;
        }
        return false;
    }
    abstract public boolean ispravanPotez(String pozicija);

    public String getPosition() {
        return pozicija;
    }

    public Color getColor() {
        return boja;
    }

    public void setBoja(Color boja) {
        this.boja = boja;
    }

    public static int getPozicijuINaTabli(String pozicija) {
        return '8' - pozicija.charAt(1);
    }

    public static int getPozicijuJNaTabli(String pozicija) {
        return 8 - ('H' - pozicija.charAt(0)) - 1;
    }

    public void setPozicija(String pozicija) {
        if(!ispravnaPozicija(pozicija)) {
            throw new IllegalArgumentException("Neispravan potez");
        }
        this.pozicija = pozicija;
    }

    public void move(String position) throws IllegalChessMoveException {
        if(!ispravnaPozicija(position.toUpperCase())) {
            throw new IllegalArgumentException("Neispravna pozicija");
        }
        if(!ispravanPotez(position.toUpperCase())) {
            throw new IllegalChessMoveException("Neispravan potez");
        }
        setPozicija(position.toUpperCase());
    }
}
