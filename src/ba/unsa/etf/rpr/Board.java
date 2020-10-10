package ba.unsa.etf.rpr;
import java.util.ArrayList;
public class Board {
    private ChessPiece[][] figuraNaTabli;
    private static boolean[][] zauzetoPoljeNaTabli;
    private boolean sah;

    private void postaviFigure(ChessPiece[][] figure) {
        for(int i = 0; i < 2; i++) {
            char asciiVrijednostPoz = 'A';
            for(int j = 0; j < 8; j++) {
                if(i == 0) {
                    if (j == 0 || j == 7) {
                        figuraNaTabli[i][j] = new Rook(asciiVrijednostPoz + "8", ChessPiece.Color.BLACK);
                    } else if (j == 1 || j == 6) {
                        figuraNaTabli[i][j] = new Knight(asciiVrijednostPoz + "8", ChessPiece.Color.BLACK);
                    } else if (j == 2 || j == 5) {
                        figuraNaTabli[i][j] = new Bishop(asciiVrijednostPoz + "8", ChessPiece.Color.BLACK);
                    } else if (j == 3) {
                        figuraNaTabli[i][j] = new Queen(asciiVrijednostPoz + "8", ChessPiece.Color.BLACK);
                    } else {
                        figuraNaTabli[i][j] = new King(asciiVrijednostPoz + "8", ChessPiece.Color.BLACK);
                    }
                }
                else {
                    figuraNaTabli[i][j] = new Pawn(asciiVrijednostPoz + "7", ChessPiece.Color.BLACK);
                }
                asciiVrijednostPoz++;
            }
        }
        for(int i = 6; i < 8; i++) {
            char asciiVrijednostPoz = 'A';
            for(int j = 0; j < 8; j++) {
                if(i == 7) {
                    if(j == 0 || j==7) {
                        figuraNaTabli[i][j] = new Rook(asciiVrijednostPoz + "1", ChessPiece.Color.WHITE);
                    }
                    else if(j == 1 || j == 6) {
                        figuraNaTabli[i][j] = new Knight(asciiVrijednostPoz + "1", ChessPiece.Color.WHITE);
                    }
                    else if(j == 2 || j == 5) {
                        figuraNaTabli[i][j] = new Bishop(asciiVrijednostPoz + "1", ChessPiece.Color.WHITE);
                    }
                    else if(j == 3) {
                        figuraNaTabli[i][j] = new Queen(asciiVrijednostPoz + "1", ChessPiece.Color.WHITE);
                    }
                    else {
                        figuraNaTabli[i][j] = new King(asciiVrijednostPoz + "1", ChessPiece.Color.WHITE);
                    }
                }
                else {
                    figuraNaTabli[i][j] = new Pawn(asciiVrijednostPoz + "2", ChessPiece.Color.WHITE);
                }
                asciiVrijednostPoz++;
            }
        }
        //slobodna mjesta na pocetku igre postavljamo na proizvoljnu vrijednost da ne bi doslo do bacanja izuzetka
        for(int i = 2; i < 6; i++) {
            for(int j = 0; j < 8; j++) {
                figuraNaTabli[i][j] = new Pawn("??", ChessPiece.Color.BLACK);
            }
        }
    }

    public static boolean daLiJeSlobodno(int i, int j) {
        return !zauzetoPoljeNaTabli[i][j];
    }

    private void oznaciZauzetaPolja(boolean[][] zauzetoPolje) {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(i <= 1 || i >= 6) zauzetoPolje[i][j] = true;
                else zauzetoPolje[i][j] = false;
            }
        }
    }

    private boolean imaLiUOkoliniProtivnika(int kraljI, int kraljJ, ChessPiece.Color boja) {
        if (kraljI > 0 && kraljI < 7 && kraljJ > 0 && kraljJ < 7) { // zasticen sa svih strana
            if ((!daLiJeSlobodno(kraljI, kraljJ + 1) && !figuraNaTabli[kraljI][kraljJ + 1].getColor().equals(boja)) ||
                    (!daLiJeSlobodno(kraljI, kraljJ - 1) && !figuraNaTabli[kraljI][kraljJ - 1].getColor().equals(boja)) ||
                    (!daLiJeSlobodno(kraljI, kraljJ) && !figuraNaTabli[kraljI][kraljJ].getColor().equals(boja)) ||
                    (!daLiJeSlobodno(kraljI + 1, kraljJ + 1) && !figuraNaTabli[kraljI + 1][kraljJ + 1].getColor().equals(boja)) ||
                    (!daLiJeSlobodno(kraljI + 1, kraljJ - 1) && !figuraNaTabli[kraljI + 1][kraljJ - 1].getColor().equals(boja)) ||
                    (!daLiJeSlobodno(kraljI + 1, kraljJ) && !figuraNaTabli[kraljI + 1][kraljJ].getColor().equals(boja)) ||
                    (!daLiJeSlobodno(kraljI - 1, kraljJ + 1) && !figuraNaTabli[kraljI - 1][kraljJ + 1].getColor().equals(boja)) ||
                    (!daLiJeSlobodno(kraljI - 1, kraljJ - 1) && !figuraNaTabli[kraljI][kraljJ - 1].getColor().equals(boja)) ||
                    (!daLiJeSlobodno(kraljI - 1, kraljJ) && !figuraNaTabli[kraljI][kraljJ].getColor().equals(boja))) {
                return true;
            }
        } else if (kraljI == 0) {
            if (kraljJ > 0 && kraljJ < 7) {
                if ((!daLiJeSlobodno(kraljI + 1, kraljJ + 1) && !figuraNaTabli[kraljI + 1][kraljJ + 1].getColor().equals(boja)) ||
                        (!daLiJeSlobodno(kraljI + 1, kraljJ - 1) && !figuraNaTabli[kraljI + 1][kraljJ - 1].getColor().equals(boja)) ||
                        (!daLiJeSlobodno(kraljI + 1, kraljJ) && !figuraNaTabli[kraljI + 1][kraljJ].getColor().equals(boja)) ||
                        (!daLiJeSlobodno(kraljI, kraljJ + 1) && !figuraNaTabli[kraljI][kraljJ + 1].getColor().equals(boja)) ||
                        (!daLiJeSlobodno(kraljI, kraljJ - 1) && !figuraNaTabli[kraljI][kraljJ - 1].getColor().equals(boja)) ||
                        (!daLiJeSlobodno(kraljI, kraljJ) && !figuraNaTabli[kraljI][kraljJ].getColor().equals(boja))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean jeLiKraljZasticen(int kI, int kJ, ChessPiece.Color boja) {
        if (kI > 0 && kI < 7 && kJ > 0 && kJ < 7) { // zasticen sa svih strana
            if ((!daLiJeSlobodno(kI, kJ + 1) && !daLiJeSlobodno(kI, kJ - 1) && !daLiJeSlobodno(kI,kJ)
                    && !daLiJeSlobodno(kI - 1, kJ) && !daLiJeSlobodno(kI + 1, kJ)
                    && !daLiJeSlobodno(kI + 1, kJ + 1) && !daLiJeSlobodno(kI + 1, kJ - 1)
                    && !daLiJeSlobodno(kI - 1, kJ + 1) && !daLiJeSlobodno(kI - 1, kJ - 1) &&
                    figuraNaTabli[kI][kJ + 1].getColor().equals(boja) && figuraNaTabli[kI][kJ - 1].getColor().equals(boja) && figuraNaTabli[kI][kJ].getColor().equals(boja)
                    && figuraNaTabli[kI - 1][kJ].getColor().equals(boja) && figuraNaTabli[kI + 1][kJ].getColor().equals(boja)
                    && figuraNaTabli[kI + 1][kJ + 1].getColor().equals(boja) && figuraNaTabli[kI + 1][kJ - 1].getColor().equals(boja)
                    && figuraNaTabli[kI - 1][kJ + 1].getColor().equals(boja) && figuraNaTabli[kI - 1][kJ - 1].getColor().equals(boja))) {
                return true;
            }
        }
        else if(kI == 0) {
            if (kJ > 0 && kJ < 7) {
                if (!daLiJeSlobodno(kI, kJ + 1) && figuraNaTabli[kI][kJ + 1].getColor().equals(boja)
                        && !daLiJeSlobodno(kI, kJ - 1) && figuraNaTabli[kI][kJ - 1].getColor().equals(boja)
                        && !daLiJeSlobodno(kI + 1, kJ) && figuraNaTabli[kI + 1][kJ].getColor().equals(boja)
                        && !daLiJeSlobodno(kI + 1, kJ + 1) && figuraNaTabli[kI + 1][kJ + 1].getColor().equals(boja)
                    && !daLiJeSlobodno(kI + 1, kJ - 1) && figuraNaTabli[kI + 1][kJ - 1].getColor().equals(boja)) {
                    return true;
                }
            }
        }
        if(imaLiUOkoliniProtivnika(kI, kJ, boja)) return false;
        return true;
    }

    private ArrayList<ChessPiece> potencijalneFigureZaPotez(Class tip, ChessPiece.Color boja) { // potencijalne figure sa kojih ce se pokusati potez na poziciju
        ArrayList<ChessPiece> pozicije = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (figuraNaTabli[i][j].getClass().equals(tip) && figuraNaTabli[i][j].getColor().equals(boja)) {
                    pozicije.add(figuraNaTabli[i][j]);
                }
            }
        }
        return pozicije;
    }

    private  boolean provjeriPreskakanjeFigura(ChessPiece figura, String trenutnaPozicija, String novaPozicija) {
        int novaPozicijaI = ChessPiece.getPozicijuINaTabli(novaPozicija), novaPozicijaJ = ChessPiece.getPozicijuJNaTabli(novaPozicija);
        int trenutnaPozicijaI = ChessPiece.getPozicijuINaTabli(trenutnaPozicija), trenutnaPozicijaJ = ChessPiece.getPozicijuJNaTabli(trenutnaPozicija);
        boolean slobodnoPolje = true;
        if(figura.getClass().equals(Bishop.class)) {
            // provjera za crnog lovca za pomjeranje desno
            if (novaPozicijaI > trenutnaPozicijaI && novaPozicijaJ > trenutnaPozicijaJ) {
                int izmedjuTIP_I = trenutnaPozicijaI + 1, izmedjuTIP_J = trenutnaPozicijaJ + 1;
                while (izmedjuTIP_I < novaPozicijaI && izmedjuTIP_J < novaPozicijaJ) {
                    if (Board.daLiJeSlobodno(izmedjuTIP_I, izmedjuTIP_J)) {
                        izmedjuTIP_I++;
                        izmedjuTIP_J++;
                    } else {
                        slobodnoPolje = false;
                        break;
                    }
                }
            }
            // provjera za crnog lovca za pomjeranje lijevo
            if (novaPozicijaI > trenutnaPozicijaI && novaPozicijaJ < trenutnaPozicijaJ) {
                int izmedjuTIP_I = trenutnaPozicijaI + 1, izmedjuTIP_J = trenutnaPozicijaJ - 1;
                while (izmedjuTIP_I < novaPozicijaI && izmedjuTIP_J > novaPozicijaJ) {
                    if (Board.daLiJeSlobodno(izmedjuTIP_I, izmedjuTIP_J)) {
                        izmedjuTIP_I++;
                        izmedjuTIP_J--;
                    } else {
                        slobodnoPolje = false;
                        break;
                    }
                }
            }
            // provjera za bijelog lovca za pomjeranje desno
            if (novaPozicijaI < trenutnaPozicijaI && novaPozicijaJ > trenutnaPozicijaJ) {
                int izmedjuTIP_I = trenutnaPozicijaI - 1, izmedjuTIP_J = trenutnaPozicijaJ + 1;
                while (izmedjuTIP_I > novaPozicijaI && izmedjuTIP_J < novaPozicijaJ) {
                    if (Board.daLiJeSlobodno(izmedjuTIP_I, izmedjuTIP_J)) {
                        izmedjuTIP_I--;
                        izmedjuTIP_J++;
                    } else {
                        slobodnoPolje = false;
                        break;
                    }
                }
            }
            // provjera za bijelog lovca za pomjeranje lijevo
            if (novaPozicijaI < trenutnaPozicijaI && novaPozicijaJ < trenutnaPozicijaJ) {
                int izmedjuTIP_I = trenutnaPozicijaI - 1, izmedjuTIP_J = trenutnaPozicijaJ - 1;
                while (izmedjuTIP_I > novaPozicijaI && izmedjuTIP_J > novaPozicijaJ) {
                    if (Board.daLiJeSlobodno(izmedjuTIP_I, izmedjuTIP_J)) {
                        izmedjuTIP_I--;
                        izmedjuTIP_J--;
                    } else {
                        slobodnoPolje = false;
                        break;
                    }
                }
            }
        }
        if(figura.getClass().equals(Rook.class)) {
            if(trenutnaPozicijaI == novaPozicijaI) {
                int izmedjuTIP_J;
                if(trenutnaPozicijaJ > novaPozicijaJ) {
                    izmedjuTIP_J = trenutnaPozicijaJ - 1;
                    while(izmedjuTIP_J > novaPozicijaJ) {
                        if(Board.daLiJeSlobodno(trenutnaPozicijaI,izmedjuTIP_J)) {
                            izmedjuTIP_J--;
                        }
                        else {
                            slobodnoPolje = false;
                            break;
                        }
                    }
                }
                else {
                    izmedjuTIP_J = trenutnaPozicijaJ + 1;
                    while(izmedjuTIP_J < novaPozicijaJ) {
                        if(Board.daLiJeSlobodno(trenutnaPozicijaI,izmedjuTIP_J)) {
                            izmedjuTIP_J++;
                        }
                        else {
                            slobodnoPolje = false;
                            break;
                        }
                    }
                }
            }
            else {
                int izmedjuTIP_I;
                if(trenutnaPozicijaI < novaPozicijaI) {
                    izmedjuTIP_I = trenutnaPozicijaI + 1;
                    while(izmedjuTIP_I < novaPozicijaI) {
                        if(Board.daLiJeSlobodno(izmedjuTIP_I,trenutnaPozicijaJ)) {
                            izmedjuTIP_I++;
                        }
                        else {
                            slobodnoPolje = false;
                            break;
                        }
                    }
                }
                else{
                    izmedjuTIP_I = trenutnaPozicijaI - 1;
                    while(izmedjuTIP_I > novaPozicijaI) {
                        if(Board.daLiJeSlobodno(izmedjuTIP_I,trenutnaPozicijaJ)) {
                            izmedjuTIP_I--;
                        }
                        else {
                            slobodnoPolje = false;
                            break;
                        }
                    }

                }
            }
        }
        if(figura.getClass().equals(Queen.class)) {
            if (novaPozicijaI > trenutnaPozicijaI && novaPozicijaJ > trenutnaPozicijaJ) { // provjera za pomjeranje dijagonalno dole desno
                int izmedjuTIP_I = trenutnaPozicijaI + 1, izmedjuTIP_J = trenutnaPozicijaJ + 1;
                while (izmedjuTIP_I < novaPozicijaI && izmedjuTIP_J < novaPozicijaJ) {
                    if (Board.daLiJeSlobodno(izmedjuTIP_I, izmedjuTIP_J)) {
                        izmedjuTIP_I++;
                        izmedjuTIP_J++;
                    } else {
                        slobodnoPolje = false;
                        break;
                    }
                }
            }
            else if (novaPozicijaI > trenutnaPozicijaI && novaPozicijaJ < trenutnaPozicijaJ) { // provjera za pomjeranje dijagonalno dole lijevo
                int izmedjuTIP_I = trenutnaPozicijaI + 1, izmedjuTIP_J = trenutnaPozicijaJ - 1;
                while (izmedjuTIP_I < novaPozicijaI && izmedjuTIP_J > novaPozicijaJ) {
                    if (Board.daLiJeSlobodno(izmedjuTIP_I, izmedjuTIP_J)) {
                        izmedjuTIP_I++;
                        izmedjuTIP_J--;
                    } else {
                        slobodnoPolje = false;
                        break;
                    }
                }
            }
            else if (novaPozicijaI < trenutnaPozicijaI && novaPozicijaJ > trenutnaPozicijaJ) { // provjera za pomjeranje dijagonalno gore desno
                int izmedjuTIP_I = trenutnaPozicijaI - 1, izmedjuTIP_J = trenutnaPozicijaJ + 1;
                while (izmedjuTIP_I > novaPozicijaI && izmedjuTIP_J < novaPozicijaJ) {
                    if (Board.daLiJeSlobodno(izmedjuTIP_I, izmedjuTIP_J)) {
                        izmedjuTIP_I--;
                        izmedjuTIP_J++;
                    } else {
                        slobodnoPolje = false;
                        break;
                    }
                }
                if (slobodnoPolje) return true;
            }
            else if (novaPozicijaI < trenutnaPozicijaI && novaPozicijaJ < trenutnaPozicijaJ) { // provjeraza pomjeranje dijegonalno gore lijevo
                int izmedjuTIP_I = trenutnaPozicijaI - 1, izmedjuTIP_J = trenutnaPozicijaJ - 1;
                while (izmedjuTIP_I > novaPozicijaI && izmedjuTIP_J > novaPozicijaJ) {
                    if (Board.daLiJeSlobodno(izmedjuTIP_I, izmedjuTIP_J)) {
                        izmedjuTIP_I--;
                        izmedjuTIP_J--;
                    } else {
                        slobodnoPolje = false;
                        break;
                    }
                }
                if (slobodnoPolje) return true;
            }
            else if (trenutnaPozicijaI == novaPozicijaI && trenutnaPozicijaJ != novaPozicijaJ) {
                int izmedjuTIP_J;
                if (trenutnaPozicijaJ > novaPozicijaJ) { // provjera za kretanje horizontalno lijevo
                    izmedjuTIP_J = trenutnaPozicijaJ - 1;
                    while (izmedjuTIP_J > novaPozicijaJ) {
                        if (Board.daLiJeSlobodno(trenutnaPozicijaI, izmedjuTIP_J)) {
                            izmedjuTIP_J--;
                        } else {
                            slobodnoPolje = false;
                            break;
                        }
                    }

                }
                else { // provjera za kretanje horizontalno desno
                    izmedjuTIP_J = trenutnaPozicijaJ + 1;
                    while (izmedjuTIP_J < novaPozicijaJ) {
                        if (Board.daLiJeSlobodno(trenutnaPozicijaI, izmedjuTIP_J)) {
                            izmedjuTIP_J++;
                        } else {
                            slobodnoPolje = false;
                            break;
                        }
                    }
                }
            }
            else {
                int izmedjuTIP_I;
                if (trenutnaPozicijaI < novaPozicijaI) { //provjera za vertikalno dole
                    izmedjuTIP_I = trenutnaPozicijaI + 1;
                    while (izmedjuTIP_I < novaPozicijaI) {
                        if (Board.daLiJeSlobodno(izmedjuTIP_I, trenutnaPozicijaJ)) {
                            izmedjuTIP_I++;
                        } else {
                            slobodnoPolje = false;
                            break;
                        }
                    }
                }
                else { // provjera vertikalno gore
                    izmedjuTIP_I = trenutnaPozicijaI - 1;
                    while (izmedjuTIP_I > novaPozicijaI) {
                        if (Board.daLiJeSlobodno(izmedjuTIP_I, trenutnaPozicijaJ)) {
                            izmedjuTIP_I--;
                        } else {
                            slobodnoPolje = false;
                            break;
                        }
                    }
                }

            }
        }
        return slobodnoPolje;
    }

    public Board() {
        figuraNaTabli = new ChessPiece[8][8];
        zauzetoPoljeNaTabli = new boolean[8][8];
        postaviFigure(figuraNaTabli);
        oznaciZauzetaPolja(zauzetoPoljeNaTabli);
        sah = false;
    }

    public boolean isCheck(ChessPiece.Color boja) {
        int kraljPozicijaI = 0, kraljPozicijaJ = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(figuraNaTabli[i][j].getColor().equals(boja) && figuraNaTabli[i][j] instanceof King) {
                    kraljPozicijaI = i;
                    kraljPozicijaJ = j;
                }
            }
        }
        if(!jeLiKraljZasticen(kraljPozicijaI,kraljPozicijaJ,boja)) {
            sah = true;
            return true;
        }
        return false;
    }

    public void move(Class type, ChessPiece.Color boja, String pozicija) throws IllegalChessMoveException {
        if(sah) return;
        ArrayList<ChessPiece> pocetnePozicije = potencijalneFigureZaPotez(type,boja);
        boolean mogucPotez = false;
        String trenutna = "";
        ChessPiece figura = null;
        for (ChessPiece fig: pocetnePozicije) { // trazimo figuru koja moze izvrsiti potez
            if(fig.ispravanPotez(pozicija.toUpperCase())) {
                mogucPotez = true;
                trenutna = fig.getPosition();
                figura = fig;
                break;
            }
        }
        if(!mogucPotez) throw new IllegalChessMoveException("Nije moguce izvrsiti pozet na zadanu poziciju");
        else {
            int novaPozicijaI = ChessPiece.getPozicijuINaTabli(pozicija.toUpperCase()), novaPozicijaJ = ChessPiece.getPozicijuJNaTabli(pozicija.toUpperCase());
            int trenutnaPozicijaI = ChessPiece.getPozicijuINaTabli(trenutna), trenutnaPozicijaJ = ChessPiece.getPozicijuJNaTabli(trenutna);
            if(!daLiJeSlobodno(novaPozicijaI,novaPozicijaJ)) {
                if(figuraNaTabli[trenutnaPozicijaI][trenutnaPozicijaJ].getColor().equals(figuraNaTabli[novaPozicijaI][novaPozicijaJ].getColor())) {
                    throw new IllegalChessMoveException("Figure su iste boje");
                }
            }
            if(figura.getClass().equals(Rook.class) || figura.getClass().equals(Queen.class)  || figura.getClass().equals(Bishop.class)) {
                if(!provjeriPreskakanjeFigura(figura,trenutna,pozicija)) {
                    throw new IllegalChessMoveException("Nema preskakanja figura");
                }
            }
            figura.move(pozicija.toUpperCase());
            zauzetoPoljeNaTabli[trenutnaPozicijaI][trenutnaPozicijaJ] = false; // staro polje oslobođeno
            zauzetoPoljeNaTabli[novaPozicijaI][novaPozicijaJ] = true; //novo polje zauzeto
            figuraNaTabli[novaPozicijaI][novaPozicijaJ].setBoja(figuraNaTabli[trenutnaPozicijaI][trenutnaPozicijaJ].getColor());
        }
    }

    public void move(String oldPosition, String newPosition) throws IllegalChessMoveException {
        if(daLiJeSlobodno(ChessPiece.getPozicijuINaTabli(oldPosition.toUpperCase()),ChessPiece.getPozicijuJNaTabli(oldPosition.toUpperCase()))) throw new IllegalArgumentException("Neispravna pocetna pozicija");
        if(sah) return;
        int novaPozicijaI = ChessPiece.getPozicijuINaTabli(newPosition.toUpperCase()), novaPozicijaJ = ChessPiece.getPozicijuJNaTabli(newPosition.toUpperCase()); // indeksi noce pozicije
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(oldPosition.toUpperCase().equals(figuraNaTabli[i][j].getPosition().toUpperCase())) {
                    if(figuraNaTabli[i][j].getClass().equals(Rook.class) || figuraNaTabli[i][j].getClass().equals(Queen.class)  || figuraNaTabli[i][j].getClass().equals(Bishop.class)) {
                        if(!provjeriPreskakanjeFigura(figuraNaTabli[i][j],oldPosition.toUpperCase(),newPosition.toUpperCase())) {
                            throw new IllegalChessMoveException("Nema preskakanja figura");
                        }
                    }
                    figuraNaTabli[i][j].move(newPosition.toUpperCase());
                    figuraNaTabli[novaPozicijaI][novaPozicijaJ].setBoja(figuraNaTabli[i][j].getColor());
                    zauzetoPoljeNaTabli[novaPozicijaI][novaPozicijaJ] = true;
                    zauzetoPoljeNaTabli[i][j] = false;
                    i = 7;
                    break;
                }
            }
        }
    }
}