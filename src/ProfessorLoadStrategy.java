public class ProfessorLoadStrategy implements ILoanStrategy {
    @Override
    public boolean checkLoanEligibility(User user, BookCopy copy) {
        return true;
    }
}
