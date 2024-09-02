package entities;

import entities.Book;

public class BookCopy {
    private final String copyCode;
    private boolean isBorrowed = false;
    private Book book;

    public BookCopy(String copyCode, Book book) {
        this.copyCode = copyCode;
        this.book = book;
        this.isBorrowed = false;
    }

    public String getCopyCode() {
        return this.copyCode;
    }

    public String getBookCode() {
        return this.book.getBookCode();
    }

    public String getTitle() {
        return this.book.getTitle();
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
