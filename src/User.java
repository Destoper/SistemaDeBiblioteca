import java.util.ArrayList;

public abstract class User {
    private ILoanStrategy loanStrategy;
    private String id;
    private String name;
    private ArrayList<BorrowedBook> borrowedBooks = new ArrayList<BorrowedBook>();
    private int maxBorrowedDays;
    private static final int MAX_BOOKINGS = 3;

    private ArrayList<ReservedBook> reservedBooks = new ArrayList<ReservedBook>();

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
            if (borrowedBook.getStatus() == LoanStatus.LATE) {
                return true;
            }
        }
        return false;
    }

    public boolean hasReserved(Book book) {
        for (ReservedBook reservedBook : this.reservedBooks) {
            if (reservedBook.getBookCode().equals(book.getBookCode())) {
                return true;
            }
        }
        return false;
    }

    public void addReservation(Book book) {
        this.reservedBooks.add(new ReservedBook(book));
    }

    public void removeReservation(Book book) {
        for (ReservedBook reservedBook : this.reservedBooks) {
            if (reservedBook.getBookCode().equals(book.getBookCode())) {
                this.reservedBooks.remove(reservedBook);
                break;
            }
        }
    }

    public ArrayList<ReservedBook> getReservedBooks() {
        return this.reservedBooks;
    }

    public boolean isReservationLimitReached() {
        return this.reservedBooks.size() >= MAX_BOOKINGS;
    }

    public void setLoanStrategy(ILoanStrategy loanStrategy) {
        this.loanStrategy = loanStrategy;
    }

    public int getNumBorrowedBooks() {
        return this.borrowedBooks.size();
    }

    public void borrowBook(BookCopy bookCopy) {

        // verifica se ja tem o livro (Nao se precisa)
        for (BorrowedBook borrowedBook : this.borrowedBooks) {
            if (borrowedBook.getBookCopy() == bookCopy) {
                return;
            }
        }

        for (ReservedBook reservedBook : this.reservedBooks) {
            if (reservedBook.getBookCode().equals(bookCopy.getBookCode())) {
                this.reservedBooks.remove(reservedBook);
                break;
            }
        }

        this.borrowedBooks.add(new BorrowedBook(bookCopy, this.maxBorrowedDays));
    }

    public void returnBookCopy(BookCopy bookCopy) {
        for (BorrowedBook reservedBook : this.borrowedBooks) {
            if (reservedBook.getBookCopy() == bookCopy) {
                reservedBook.returnBookCopy();
                break;
            }
        }
    }

    public abstract boolean isAvailable();
}
