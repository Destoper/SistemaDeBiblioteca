package ErrorsHandlers;

public class DoubleReservationException extends RuntimeException {
    public DoubleReservationException() {
        super("O usuário já reservou este livro.");
    }
}
