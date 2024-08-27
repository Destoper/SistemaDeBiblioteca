public class StudentLoanStrategy implements ILoanStrategy {
    @Override
    public boolean checkLoanEligibility(User user, Book book) {
        if (book.isFullyBorrowed() || !user.isAvailable()) {
            return false;
        }

        return !book.isFullyReserved(user) || user.hasReserved(book);
    }
}

