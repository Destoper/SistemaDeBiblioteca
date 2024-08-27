public class ObserverCommand implements ICommand {
    private Library library;
    private String userCode;
    private String bookCode;

    public ObserverCommand(Library library, String userCode, String bookCode) {
        this.library = library;
        this.userCode = userCode;
        this.bookCode = bookCode;
    }

    @Override
    public void execute() {
        library.addObserver(userCode, bookCode);
    }
    
}
