package entities;

import entities.Book;

import java.time.LocalDate;

public class ReservedBook {
    private Book book;
    private LocalDate borrowedDate;


    public ReservedBook(Book book){
        this.book = book;
        this.borrowedDate = LocalDate.now();
    }

    public Book getBook(){
        return this.book;
    }

    public LocalDate getDateBorrowed(){
        return borrowedDate;
    }

    public String getBookCode(){
        return book.getBookCode();
    }

    public String getTitle(){
        return book.getTitle();
    }
}
