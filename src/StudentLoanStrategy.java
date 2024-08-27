import ErrorsHandlers.*;

public class StudentLoanStrategy implements ILoanStrategy {
    @Override
    public boolean checkLoanEligibility(User user, Book book) {
        if (book.isFullyBorrowed()) {
            throw new FullyBorrowedException();
        }

        if (!user.isAvailable()) {
            throw new UserNotAvailableException();
        }

        if (book.isFullyReserved(user) && !user.hasReserved(book)) {
            throw new BookNotReservedByUserException();
        }

        return true;
    }
}
