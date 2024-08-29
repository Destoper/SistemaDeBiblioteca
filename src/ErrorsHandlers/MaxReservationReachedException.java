package ErrorsHandlers;

public class MaxReservationReachedException extends RuntimeException {
    public MaxReservationReachedException() {
        super("[!] O limite de reservas foi atingido.");
    }
}
