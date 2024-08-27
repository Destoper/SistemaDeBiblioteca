public class ReserveCommand implements Command{
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
