import java.util.ArrayList;

public class Book implements ISubject, IReservable {
    private String bookCode;
    private String title;
    private String authors;
    private String publisher;
    private String year;
    private String edition;
    private ArrayList<BookCopy> copies;
    private ArrayList<User> usersWhoBooked;
    private ArrayList<IObserver> observers;
    private final static int MIN_NOTIFY_OBSERVERS = 2;

    public Book(String bookCode, String title, String authors, String publisher, String year, String edition) {
        this.bookCode = bookCode;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.edition = edition;
        this.copies = new ArrayList<>();
        this.usersWhoBooked = new ArrayList<>();
        this.observers = new ArrayList<>();
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

    public void receiveReservationRequest(User user) {
        if(!user.isReservationLimitReached()) {
            this.usersWhoBooked.add(user);
            user.addReservation(this);
        }

        if (this.usersWhoBooked.size() >= MIN_NOTIFY_OBSERVERS) {
            this.notifyObservers();
        }
    }

    public void removeReservationRequest(User user) {
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

    public void removeCopyByCopyCode(String copyCode) {
        for (BookCopy copy : this.copies) {
            if (copy.getCopyCode().equals(copyCode)) {
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


    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getYear() {
        return year;
    }

    public String getEdition() {
        return edition;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

}
