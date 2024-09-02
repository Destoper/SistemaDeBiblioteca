package strategy;

import entities.User;

public class PostGradStudent extends User {
    static final int MAX_BORROWED_BOOKS = 4;
    static final int MAX_BORROWED_DAYS = 5;

    public PostGradStudent(String id, String name, ILoanStrategy loanStrategy) {
        super(id, name, loanStrategy, MAX_BORROWED_DAYS);
    }

    @Override
    public boolean isAvailable() {
        return !super.isInDebt() && !this.isFull();
    }

    public boolean isFull() {
        return super.getNumBorrowedBooks() >= MAX_BORROWED_BOOKS;
    }

}
