public class StudentLoanStrategy implements ILoanStrategy {
    @Override
    public boolean checkLoanEligibility(User user, BookCopy copy) {
        return true;
    }
}
