package strategy;

import entities.Book;
import entities.User;

public interface ILoanStrategy {
    public boolean checkLoanEligibility(User user, Book book);
}
