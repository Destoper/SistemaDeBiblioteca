public class Professor extends User{
    static final int MAX_BORROWED_BOOKS = 3;


    public Professor(String id, String name, ILoanStrategy loanStrategy) {
        super(id, name, loanStrategy, MAX_BORROWED_BOOKS);
    }

    @Override
    public boolean isAvailable(){
        return !super.isInDebt();
    }
}
