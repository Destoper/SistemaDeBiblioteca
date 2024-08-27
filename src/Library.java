import java.util.ArrayList;
public class Library {
    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<Book> books = new ArrayList<>();

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
        return null;
    }

    public Book getBook(String bookCode) {
        for (Book book : books) {
            if (book.getBookCode().equals(bookCode)) {
                return book;
            }
        }
        return null;
    }

    public void loanBook(String userCode, String bookCode) {
        // Lógica de empréstimo
        User user = getUser(userCode);
        Book book = getBook(bookCode);
        System.out.println(user.getName());
        System.out.println(book.getTitle());
        try {
            user.borrowBook(book);
            System.out.println("Empréstimo realizado para usuário: " + userCode + " com livro: " + bookCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(String userCode, String bookCode) {
        User user = getUser(userCode);
        try {
            user.returnBookCopy(bookCode);
            System.out.println("Livro devolvido pelo usuário: " + userCode + " com livro: " + bookCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reserveBook(String userCode, String bookCode) {
        User user = getUser(userCode);
        Book book = getBook(bookCode);
        try {
            book.receiveReservationRequest(user);
            System.out.println("Reserva realizada para usuário: " + userCode + " com livro: " + bookCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
