public interface ILoanStrategy {
    public boolean checkLoanEligibility(User user, BookCopy copy);
}
