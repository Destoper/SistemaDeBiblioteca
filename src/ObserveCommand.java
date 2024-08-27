public class ObserveCommand implements ICommand {
    private Library library;
    private String userCode;
    private String bookCode;

    public ObserveCommand(Library library, String userCode, String bookCode) {
        this.library = library;
        this.userCode = userCode;
        this.bookCode = bookCode;
    }

    @Override
    public void execute() {
        library.addObserver(userCode, bookCode);
    }
    
}
