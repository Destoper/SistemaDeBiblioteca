package entities;

import entities.User;
import strategy.ILoanStrategy;

public class GradStudent extends User {
    static final int MAX_BORROWED_BOOKS = 3;
    static final int MAX_BORROWED_DAYS = 3;

    public GradStudent(String id, String name, ILoanStrategy loanStrategy) {
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
