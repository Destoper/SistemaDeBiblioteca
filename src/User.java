public abstract class User {
    private ILoanStrategy loanStrategy;
    private String id;
    private String name;

    public User(String id, String name, ILoanStrategy loanStrategy) {
        this.id = id;
        this.name = name;
        this.loanStrategy = loanStrategy;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean canBorrow(BookCopy copy) {
        return this.loanStrategy.checkLoanEligibility(this, copy);
    }
 }
