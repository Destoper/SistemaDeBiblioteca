package system;

import java.util.ArrayList;

import ErrorsHandlers.BookNotRegisteredException;
import ErrorsHandlers.UserNotRegisteredException;
import entities.*;

public class Library {
    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<Book> books = new ArrayList<>();
    private LibraryConsole console = LibraryConsole.getInstance(this);

    public void addUser(User user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public User getUser(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new UserNotRegisteredException(id);
    }

    public Book getBook(String bookCode) {
        for (Book book : books) {
            if (book.getBookCode().equals(bookCode)) {
                return book;
            }
        }
        throw new BookNotRegisteredException(bookCode);
    }

    public void loanBook(String userCode, String bookCode) {

        try {
            User user = getUser(userCode);
            Book book = getBook(bookCode);
            user.borrowBook(book);

            this.console.clearConsole();
            this.console.printMessage("");
            this.console.printMessage("[-] Empréstimo realizado para usuário " + user.getName() + " (" + userCode + ")"
                    + " com livro: " + book.getTitle() + " (" + bookCode + ")");
            this.console.printMessage("");
        } catch (Exception e) {
            this.console.clearConsole();
            this.console.printMessage("");
            this.console.printMessage(e.getMessage());
            this.console.printMessage("");
        }
    }

    public void returnBook(String userCode, String bookCode) {
        try {
            User user = getUser(userCode);
            user.returnBookCopy(bookCode);

            this.console.clearConsole();
            this.console.printMessage("");
            this.console.printMessage("[-] Livro " + bookCode + " devolvido pelo usuário " + user.getName() + " (" + userCode + ")");
            this.console.printMessage("");
        } catch (Exception e) {
            this.console.clearConsole();
            this.console.printMessage("");
            this.console.printMessage(e.getMessage());
            this.console.printMessage("");
        }
    }

    public void reserveBook(String userCode, String bookCode) {
        try {
            User user = getUser(userCode);
            Book book = getBook(bookCode);
            book.receiveReservationRequest(user);

            this.console.clearConsole();
            this.console.printMessage("");
            this.console.printMessage("[-] Reserva realizada para usuário " + user.getName() + " (" + userCode + ")"
                    + " com livro: " + book.getTitle() + " (" + bookCode + ")");
            this.console.printMessage("");
        } catch (Exception e) {
            this.console.clearConsole();
            this.console.printMessage("");
            this.console.printMessage(e.getMessage());
            this.console.printMessage("");
        }
    }

    public void listBooks(String bookCode) {
        try {
            Book book = getBook(bookCode);

            this.console.clearConsole();
            this.console.printMessage("----------------------=================----------------------");
            this.console.printMessage("Título: " + book.getTitle());

            this.console.printMessage("----------------------=================----------------------");
            int numReservations = book.getUsersWhoReserved().size();
            this.console.printMessage("Quantidade de reservas: " + numReservations);

            if (numReservations > 0) {
                this.console.printMessage("Usuários que fizeram reservas:");
                for (User user : book.getUsersWhoReserved()) {
                    this.console.printMessage("- " + user.getName());
                    this.console.printMessage("");
                }
            }

            this.console.printMessage("----------------------=================----------------------");

            this.console.printMessage("Detalhes dos exemplares:");

            this.console.printMessage("----------------------=================----------------------");

            for (BookCopy copy : book.getCopies()) {
                this.console.printMessage("Código do exemplar: " + copy.getCopyCode());
                if (!copy.isBorrowed()) {
                    this.console.printMessage("Status: Disponível");
                } else {
                    for (User user : this.users) {
                        for (BorrowedBook borrowedBook : user.getBorrowedBooks()) {
                            if (borrowedBook.getBookCopy().getCopyCode().equals(copy.getCopyCode())) {
                                this.console.printMessage("Status: Emprestado");
                                this.console.printMessage("Emprestado por: " + user.getName());
                                this.console.printMessage("Data de empréstimo: " + borrowedBook.getDateBorrowed());
                                this.console.printMessage(
                                        "Data prevista para devolução: " + borrowedBook.getDateReturned());
                            }
                        }
                    }
                }
                this.console.printMessage("----------------------*****************----------------------");
                this.console.printMessage("");
            }
        } catch (Exception e) {
            this.console.clearConsole();
            this.console.printMessage("");
            this.console.printMessage(e.getMessage());
            this.console.printMessage("");
        }
    }

    public void listUser(String userCode) {
        try {
            User user = getUser(userCode);

            this.console.clearConsole();

            this.console.printMessage("----------------------=================----------------------");

            this.console.printMessage("Empréstimos de " + user.getName() + ":");

            this.console.printMessage("----------------------=================----------------------");
            for (BorrowedBook borrowedBook : user.getBorrowedBooks()) {
                this.console.printMessage("Título: " + borrowedBook.getTitle());
                this.console.printMessage("Data do Empréstimo: " + borrowedBook.getDateBorrowed());
                this.console.printMessage("Status: " + borrowedBook.getSemanticStatus());
                this.console.printMessage("Data de Devolução: " + borrowedBook.getDateReturned());
                this.console.printMessage("");
            }

            this.console.printMessage("----------------------=================----------------------");

            this.console.printMessage("Reservas de " + user.getName() + ":");

            for (ReservedBook reservedBook : user.getReservedBooks()) {
                this.console.printMessage("Título: " + reservedBook.getTitle());
                this.console.printMessage("Data da Solicitação: " + reservedBook.getDateBorrowed());
                this.console.printMessage("");
            }
            this.console.printMessage("----------------------=================----------------------");
            this.console.printMessage("");
        } catch (Exception e) {
            this.console.clearConsole();
            this.console.printMessage("");
            this.console.printMessage(e.getMessage());
            this.console.printMessage("");
        }
    }

    public void addObserver(String userCode, String bookCode) {
        try {
            Book book = getBook(bookCode);
            User user = getUser(userCode);

            this.console.clearConsole();

            Professor professor = (Professor) user;
            book.registerObserver(professor);
            this.console
                    .printMessage("[-] O professor "+ user.getName() +" (" + userCode + ") foi registrado como observador do livro " + book.getTitle() + " (" + bookCode + ")");
            this.console.printMessage("");

        } catch (Exception e) {
            this.console.clearConsole();
            this.console.printMessage("");
            this.console.printMessage(e.getMessage());
            this.console.printMessage("");
        }
    }

    public void notifyUser(String userCode) {
        try {
            User user = getUser(userCode);

            this.console.clearConsole();
            Professor professor = (Professor) user;
            System.out
                    .println("[-] O professor " + user.getName() + " (" + userCode + ") foi notificado"+ professor.getTimesNotified() + " vezes.");
            this.console.printMessage("");
        } catch (Exception e) {
            this.console.clearConsole();
            this.console.printMessage("");
            this.console.printMessage(e.getMessage());
            this.console.printMessage("");
        }
    }
}
