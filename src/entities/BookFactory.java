public class BookFactory {
    private static int copyCodeCounter = 0;

    public static Book createBook(String bookCode, String title, String authors, String publisher, String year, String edition) {
        return new Book(bookCode, title, authors, publisher, year, edition);
    }

    public static BookCopy createBookCopy(Book book) {
        String copyCode = generateCopyCode();
        return new BookCopy(copyCode, book);
    }

    private static synchronized String generateCopyCode() {
        return String.valueOf(copyCodeCounter++);
    }
}