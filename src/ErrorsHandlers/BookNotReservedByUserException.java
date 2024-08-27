package ErrorsHandlers;

public class BookNotReservedByUserException extends RuntimeException {
    public BookNotReservedByUserException() {
        super("O livro esta completamente reservado e o aluno nao possui nenhuma reserva.");
    }
}