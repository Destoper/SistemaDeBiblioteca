package command;


import system.Library;

public class ReturnCommand implements ICommand {
    private Library library;
    private String userCode;
    private String bookCode;

    public ReturnCommand(Library library, String userCode, String bookCode) {
        this.library = library;
        this.userCode = userCode;
        this.bookCode = bookCode;
    }

    @Override
    public void execute() {
        library.returnBook(userCode, bookCode);
    }
}
