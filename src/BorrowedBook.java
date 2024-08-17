import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class BorrowedBook{
    private BookCopy borrowedBook;
    private LocalDate dateBorrowed;

    public BorrowedBook(BookCopy borrowedBook, LocalDate dateBorrowed){
        this.borrowedBook = borrowedBook;
        this.dateBorrowed = dateBorrowed;
    }

    public BookCopy getBorrowedBook(){
        return borrowedBook;
    }

    public LocalDate getDateBorrowed(){
        return dateBorrowed;
    }

    public void setBorrowedBook(BookCopy borrowedBook){
        this.borrowedBook = borrowedBook;
    }

    public void setDateBorrowed(LocalDate dateBorrowed){
        this.dateBorrowed = dateBorrowed;
    }

    public String getBookCode(){
        return borrowedBook.getCode();
    }

    public int daysPassed() {
        LocalDate currentDate = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(dateBorrowed, currentDate);
    }

}