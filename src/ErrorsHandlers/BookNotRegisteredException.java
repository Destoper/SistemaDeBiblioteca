package ErrorsHandlers;

public class BookNotRegisteredException extends RuntimeException {
    public BookNotRegisteredException(String id) {
        super("[!] O livro com codigo "+ id +" não está registrado na biblioteca.");
    }
}

