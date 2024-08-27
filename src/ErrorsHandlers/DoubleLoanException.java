package ErrorsHandlers;

public class DoubleLoanException extends RuntimeException {
    public DoubleLoanException() {
        super("O usuário já pegou este livro emprestado.");
    }
}
