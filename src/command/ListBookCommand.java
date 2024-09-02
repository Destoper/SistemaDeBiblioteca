package command;

import system.Library;

public class ListBookCommand implements ICommand {

    private final Library library;
    private String bookCode;

    public ListBookCommand(Library library, String bookCode) {
        this.library = library;
        this.bookCode = bookCode;
    }

    public void execute() {
        library.listBooks(bookCode);
    }
}