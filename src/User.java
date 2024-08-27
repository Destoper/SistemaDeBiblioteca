import java.util.ArrayList;

public abstract class User {
    private ILoanStrategy loanStrategy;
    private String id;
    private String name;
    private ArrayList<BorrowedBook> borrowedBooks = new ArrayList<BorrowedBook>();
    private int maxBorrowedDays;
    private static final int MAX_RESERVATIONS = 3;

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
        if (this.isReservationLimitReached()) {
            throw new RuntimeException("User has reached the maximum number of reservations");
        }

        if (this.hasReserved(book)) {
            throw new RuntimeException("User has already reserved this book");
        }

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

    public ArrayList<BorrowedBook> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public boolean isReservationLimitReached() {
        return this.reservedBooks.size() >= MAX_RESERVATIONS;
    }

    public void setLoanStrategy(ILoanStrategy loanStrategy) {
        this.loanStrategy = loanStrategy;
    }

    public int getNumBorrowedBooks() {
        return this.borrowedBooks.size();
    }

    public void borrowBook(Book book) {
        BookCopy bookCopy = book.getAvailableCopy();
        // verifica se ja tem o livro (Nao se precisa)
        for (BorrowedBook borrowedBook : this.borrowedBooks) {
            if (borrowedBook.getBookCopy() == bookCopy) {
                throw new RuntimeException("User already has this book borrowed");
            }
        }

        if (this.canBorrow(book)) {
            bookCopy.setBorrowed(true);
            this.borrowedBooks.add(new BorrowedBook(bookCopy, this.maxBorrowedDays));
        } else {
            throw new RuntimeException("User cannot borrow this book");
        }

        for (ReservedBook reservedBook : this.reservedBooks) {
            if (reservedBook.getBookCode().equals(bookCopy.getBook().getBookCode())) {
                this.reservedBooks.remove(reservedBook);
                break;
            }
        }

    }

    public void returnBookCopy(String bookCode) {

        for (BorrowedBook reservedBook : this.borrowedBooks) {
            if (reservedBook.getBookCode().equals(bookCode)) {
                reservedBook.returnBookCopy();
                this.borrowedBooks.remove(reservedBook);
                return;
            }
        }
        throw new RuntimeException("User does not have this book borrowed");
    }

    public abstract boolean isAvailable();
}
