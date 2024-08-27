package ErrorsHandlers;

public class NothingToReturnException extends RuntimeException{
    public NothingToReturnException() {
        super("O usuário não possui o livro a ser devolvido.");
    }
}
