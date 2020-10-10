package ba.unsa.etf.rpr;

public class IllegalChessMoveException extends Exception{
    public IllegalChessMoveException() {
        super();
    }
    public IllegalChessMoveException(String poruka) {
        super(poruka);
    }
    public IllegalChessMoveException(String poruka, Throwable throwable) {
        super(poruka,throwable);
    }

}
