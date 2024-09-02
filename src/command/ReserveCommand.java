package command;

import system.Library;

public class ReserveCommand implements ICommand {
    private Library library;
    private String userCode;
    private String bookCode;

    public ReserveCommand(Library library, String userCode, String bookCode) {
        this.library = library;
        this.userCode = userCode;
        this.bookCode = bookCode;
    }

    @Override
    public void execute() {
        library.reserveBook(userCode, bookCode);
    }
}
