import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class BorrowedBook{
    private BookCopy bookCopy;
    private LocalDate dateBorrowed;
    private LocalDate dateReturned;
    private LoanStatus status;

    public BorrowedBook(BookCopy bookCopy, int userMaxBorrowedDays){
        this.bookCopy = bookCopy;
        this.dateBorrowed = LocalDate.now();
        this.status = LoanStatus.BORROWED;
        this.dateReturned = dateBorrowed.plusDays(userMaxBorrowedDays);
    }

    public BookCopy getBookCopy(){
        return this.bookCopy;
    }

    public LocalDate getDateBorrowed(){
        return this.dateBorrowed;
    }

    public String getBookCode(){
        return this.bookCopy.getBook().getBookCode();
    }

    public String getTitle(){
        return this.bookCopy.getTitle();
    }

    public String getSemanticStatus(){
        if (this.status == LoanStatus.BORROWED && LocalDate.now().isAfter(dateReturned)){
            return "Atrasado";
        }
        return this.status == LoanStatus.RETURNED ? "Finalizado" : "Em curso";
    }

    public LoanStatus getStatus(){
        if (this.status == LoanStatus.BORROWED && LocalDate.now().isAfter(dateReturned)){
            return LoanStatus.LATE;
        }
        return this.status;
    }

    public void returnBookCopy(){
        this.status = LoanStatus.RETURNED;
        this.bookCopy.setBorrowed(false);
        this.dateReturned = LocalDate.now();
    }

    public int daysPassed() {
        LocalDate currentDate = LocalDate.now();
        return (int) ChronoUnit.DAYS.between(dateBorrowed, currentDate);
    }

    public LocalDate getDateReturned(){
        return this.dateReturned;
    }

}