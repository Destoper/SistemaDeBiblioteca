package ErrorsHandlers;

public class UserNotRegisteredException extends RuntimeException {
    public UserNotRegisteredException(String id) {
        super("O usuário com codigo "+ id +" não está registrado na biblioteca.");
    }
}
