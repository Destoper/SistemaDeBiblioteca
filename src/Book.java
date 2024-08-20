import java.util.ArrayList;

public class Book implements ISubject {
    private ArrayList<BookCopy> copies;
    private ArrayList<User> usersWhoBooked;
    private String bookCode;
    private final static int MIN_NOTIFY_OBSERVERS = 2;

    private ArrayList<IObserver> observers; 

    public Book(String bookCode) {    
        this.bookCode = bookCode;
        this.copies = new ArrayList<BookCopy>();
        this.usersWhoBooked = new ArrayList<User>();
        this.observers = new ArrayList<IObserver>();
    }

    public void addCopy(BookCopy copy) {
        this.copies.add(copy);
    }

    public ArrayList<BookCopy> getCopies() {
        return this.copies;
    }

    public BookCopy getCopyByCopyCode(String copieCode) {
        for (BookCopy copy : this.copies) {
            if (copy.getCopyCode().equals(copieCode)) {
                return copy;
            }
        }
        return null;
    }

    public void receiveBookingRequest(User user) {
        this.usersWhoBooked.add(user);

        if (this.usersWhoBooked.size() >= MIN_NOTIFY_OBSERVERS) {
            this.notifyObservers();
        }
    }

    public void removeBookingRequest(User user) {
        this.usersWhoBooked.remove(user);
    }

    public int getNumAvailableCopies() {
        int count = 0;
        for (BookCopy copy : this.copies) {
            if (!copy.isBorrowed()) {
                count++;
            }
        }
        return count;
    }

    public boolean isFullyBorrowed() {
        return this.getNumAvailableCopies() == 0;
    }

    public boolean isFullyBooked() {
        return this.usersWhoBooked.size() >= this.copies.size();
    }

    public void removeCopyByCopyCode(String copieCode) {
        for (BookCopy copy : this.copies) {
            if (copy.getCopyCode().equals(copieCode)) {
                this.copies.remove(copy);
                return;
            }
        }
    }

    public void updateCopyByCopyCode(String copyCode, boolean isBorrowed) {
        for (BookCopy copy : this.copies) {
            if (copy.getCopyCode().equals(copyCode)) {
                copy.setBorrowed(isBorrowed);
                return;
            }
        }
    }

    public String getBookCode() {
        return this.bookCode;
    }


    // Methods for observer pattern
    @Override
    public void registerObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : this.observers) {
            observer.update();
        }
    }

}
