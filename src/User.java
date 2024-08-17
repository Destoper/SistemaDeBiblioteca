import java.util.ArrayList;

public abstract class User {
    private ILoanStrategy loanStrategy;
    private String id;
    private String name;
    private ArrayList<BorrowedBook> borrowedBooks = new ArrayList<BorrowedBook>();
    private int maxBorrowedDays;

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
        for (BorrowedBook borrowedBook : this.borrowedBooks) {
            if (borrowedBook.getBookCode().equals(book)) {
                return true;
            }
        }
        return false;
    }

    public int getNumBorrowedBooks() {
        return this.borrowedBooks.size();
    }

    public abstract boolean isAvailable();
}
