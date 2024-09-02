package entities;

import observer.IObserver;
import strategy.ILoanStrategy;

public class Professor extends User implements IObserver {
    static final int MAX_BORROWED_BOOKS = 3;
    private int timesNotified;
    
    public Professor(String id, String name, ILoanStrategy loanStrategy) {
        super(id, name, loanStrategy, MAX_BORROWED_BOOKS);
        this.timesNotified = 0;
    }

    @Override
    public boolean isAvailable(){
        return !super.isInDebt();
    }

    @Override
    public void update() {
       this.timesNotified += 1;
    }

    public int getTimesNotified(){
        return this.timesNotified;
    }
}
