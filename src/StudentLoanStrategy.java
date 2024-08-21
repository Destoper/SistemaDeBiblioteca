public class StudentLoanStrategy implements ILoanStrategy {
    @Override
    public boolean checkLoanEligibility(User user, Book book) {
        if (book.isFullyBorrowed() || !user.isAvailable()) {
            return false;
        }

        return !book.isFullyBooked() || user.hasReserved(book);
    }
}

