public class BookCopy {
    private final String copyCode;
    private boolean isBorrowed = false;
    private Book book;

    public BookCopy(String copyCode, Book book) {
        this.copyCode = copyCode;
        this.book = book;
        this.isBorrowed = false;
    }

    public String getCopyCode() {
        return this.copyCode;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

}
