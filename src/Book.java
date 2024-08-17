import java.util.ArrayList;

public class Book {
    private ArrayList<BookCopy> copies;
    private ArrayList<User> usersWhoBooked;
    private String bookId;

    public Book(String bookId) {
        this.copies = new ArrayList<BookCopy>();
        this.usersWhoBooked = new ArrayList<User>();
        this.bookId = bookId;
    }

    
    public void addCopy(BookCopy copy) {
        this.copies.add(copy);
    }

    public ArrayList<BookCopy> getCopies() {
        return this.copies;
    }

    public BookCopy getCopyById(String id) {
        for (BookCopy copy : this.copies) {
            if (copy.getId().equals(id)) {
                return copy;
            }
        }
        return null;
    }

    public void receiveBookingRequest(User user) {
        this.usersWhoBooked.add(user);
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

    public void removeCopyById(String id) {
        for (BookCopy copy : this.copies) {
            if (copy.getId().equals(id)) {
                this.copies.remove(copy);
                return;
            }
        }
    }

    public void updateCopyById(String id, boolean isBorrowed) {
        for (BookCopy copy : this.copies) {
            if (copy.getId().equals(id)) {
                copy.setBorrowed(isBorrowed);
                return;
            }
        }
    }

    public String getBookId() {
        return this.bookId;
    }

    
}
