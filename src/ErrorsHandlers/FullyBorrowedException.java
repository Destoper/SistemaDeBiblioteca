package ErrorsHandlers;

public class FullyBorrowedException extends RuntimeException {
    public FullyBorrowedException() {
        super("Todas as cópias deste livro já foram emprestadas.");
    }
}