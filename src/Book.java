import java.util.ArrayList;

public class Book {
    private ArrayList<BookCopy> copies;

    public Book() {
        this.copies = new ArrayList<BookCopy>();
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
}
