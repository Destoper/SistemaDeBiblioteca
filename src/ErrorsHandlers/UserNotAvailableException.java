package ErrorsHandlers;

public class UserNotAvailableException extends RuntimeException {
    public UserNotAvailableException() {
        super("[!] O usuário não está em debito com a biblioteca.");
    }
}
