public class LoanCommand implements ICommand {
    private Library library;
    private String userCode;
    private String bookCode;

    public LoanCommand(Library library, String userCode, String bookCode) {
        this.library = library;
        this.userCode = userCode;
        this.bookCode = bookCode;
    }

    @Override
    public void execute() {
        library.loanBook(userCode, bookCode);
    }
}
