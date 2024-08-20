public class BookCopy {
    private final String copyCode;
    private final String bookCode;
    private String title;
    private String authors;
    private String publisher;
    private String year;
    private String edition;
    private boolean isBorrowed = false;

    public BookCopy(String copyCode, String bookCode, String title, String authors, String publisher, String year, String edition) {
        this.copyCode = copyCode;
        this.bookCode = bookCode;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.edition = edition;
    }

    public String getCopyCode() {
        return this.copyCode;
    }

    public String getCode() {
        return bookCode;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getYear() {
        return year;
    }

    public String getEdition() {
        return edition;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

}
