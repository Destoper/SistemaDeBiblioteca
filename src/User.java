import java.util.ArrayList;
import java.time.LocalDate;

public abstract class User {
    private ILoanStrategy loanStrategy;
    private String id;
    private String name;
    private ArrayList<BorrowedBook> borrowedBooks = new ArrayList<BorrowedBook>();
    private int maxBorrowedDays;
    private static final int MAX_BOOKINGS = 3;

    private ArrayList<Book> bookedBooks = new ArrayList<Book>();

    public User(String id, String name, ILoanStrategy loanStrategy, int maxBorrowedDays) {
        this.id = id;
        this.name = name;
        this.loanStrategy = loanStrategy;
        this.borrowedBooks = new ArrayList<BorrowedBook>();
        this.maxBorrowedDays = maxBorrowedDays;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean canBorrow(Book book) {
        return this.loanStrategy.checkLoanEligibility(this, book);
    }

    public boolean isInDebt() {
        for (BorrowedBook borrowedBook : this.borrowedBooks) {
            if (borrowedBook.daysPassed() > this.maxBorrowedDays) {
                return true;
            }
        }
        return false;
    }

    public boolean hasBooking(Book book) {
        for (Book bookedBook : this.bookedBooks) {
            if (bookedBook.getBookCode().equals(book.getBookCode())) {
                return true;
            }
        }
        return false;
    }

    public void addBooking(Book book) {
        this.bookedBooks.add(book);
    }

    public void removeBooking(Book book) {
        this.bookedBooks.remove(book);
    }

    public ArrayList<Book> getBookedBooks() {
        return this.bookedBooks;
    }

    public void setLoanStrategy(ILoanStrategy loanStrategy) {
        this.loanStrategy = loanStrategy;
    }

    public boolean isReservationLimitReached() {
        return this.bookedBooks.size() >= MAX_BOOKINGS;
    }

    public int getNumBorrowedBooks() {
        return this.borrowedBooks.size();
    }

    public void borrowBook(BookCopy bookCopy) {
        this.borrowedBooks.add(new BorrowedBook(bookCopy, LocalDate.now()));
    }

    public void returnBook(BookCopy bookCopy) {
        for (BorrowedBook borrowedBook : this.borrowedBooks) {
            if (borrowedBook.getBorrowedBook() == bookCopy) {
                this.borrowedBooks.remove(borrowedBook);
                break;
            }
        }
    }

    public abstract boolean isAvailable();
}
