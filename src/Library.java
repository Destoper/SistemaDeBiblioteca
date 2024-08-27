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
        throw new RuntimeException("Usuário com o código " + id + " não encontrado.");
    }

    public Book getBook(String bookCode) {
        for (Book book : books) {
            if (book.getBookCode().equals(bookCode)) {
                return book;
            }
        }
        throw new RuntimeException("Livro com o código " + bookCode + " não encontrado.");
    }

    public void loanBook(String userCode, String bookCode) {
        // Lógica de empréstimo
        try {
            User user = getUser(userCode);
            Book book = getBook(bookCode);

            System.out.println(user.getName());
            System.out.println(book.getTitle());
            user.borrowBook(book);
            
            System.out.println("Empréstimo realizado para usuário: " + userCode + " com livro: " + bookCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(String userCode, String bookCode) {
        try {
            User user = getUser(userCode);
            user.returnBookCopy(bookCode);
            System.out.println("Livro devolvido pelo usuário: " + userCode + " com livro: " + bookCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reserveBook(String userCode, String bookCode) {
        try {
            User user = getUser(userCode);
            Book book = getBook(bookCode);
            book.receiveReservationRequest(user);
            System.out.println("Reserva realizada para usuário: " + userCode + " com livro: " + bookCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listBooks(String bookCode){
        try {
        Book book = getBook(bookCode);

        // Imprime o título do livro
        System.out.println("Título: " + book.getTitle());

        // Imprime a quantidade de reservas
        int numReservations = book.getUsersWhoReserved().size();
        System.out.println("Quantidade de reservas: " + numReservations);

        // Se houver reservas, imprime os nomes dos usuários que fizeram as reservas
        if (numReservations > 0) {
            System.out.println("Usuários que fizeram reservas:");
            for (User user : book.getUsersWhoReserved()) {
                System.out.println("- " + user.getName());
            }
        }

        // Para cada exemplar, imprime as informações relevantes
        System.out.println("Detalhes dos exemplares:");
        for (BookCopy copy : book.getCopies()) {
            System.out.println("Código do exemplar: " + copy.getCopyCode());
            if (!copy.isBorrowed()) {
                System.out.println("Status: Disponível");
            } else {
                // Se o exemplar estiver emprestado, recupere os detalhes do empréstimo
                for(User user: this.users){
                    for(BorrowedBook borrowedBook: user.getBorrowedBooks()){
                        if(borrowedBook.getBookCopy().getCopyCode().equals(copy.getCopyCode())){
                            System.out.println("Status: Emprestado");
                            System.out.println("Emprestado por: " + user.getName());
                            System.out.println("Data de empréstimo: " + borrowedBook.getDateBorrowed());
                            System.out.println("Data prevista para devolução: " + borrowedBook.getDateReturned());
                        }
                    }
                }
                // BorrowedBook borrowedBook = copy.getBorrowedBookInfo(); 
            
                // System.out.println("Status: Emprestado");
                // System.out.println("Emprestado por: " + borrowedBook.getBookCopy().getBorrower().getName());
                // System.out.println("Data de empréstimo: " + borrowedBook.getDateBorrowed());
                // System.out.println("Data prevista para devolução: " + borrowedBook.getDateReturned());
            }
            System.out.println(); // Linha em branco para separar os exemplares
        }
    }catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }

    public void listUser(String userCode) {
        try {
            User user = getUser(userCode);
    
            System.out.println("Empréstimos de " + user.getName() + ":");
        
            // Listando todos os empréstimos
            for (BorrowedBook borrowedBook : user.getBorrowedBooks()) {
                System.out.println("Título: " + borrowedBook.getTitle());
                System.out.println("Data do Empréstimo: " + borrowedBook.getDateBorrowed());
                System.out.println("Status: " + (borrowedBook.getStatus() == LoanStatus.RETURNED ? "Finalizado" : "Em curso"));
                System.out.println("Data de Devolução: " + borrowedBook.getDateReturned());
                System.out.println();
            }
        
            System.out.println("Reservas de " + user.getName() + ":");
        
            // Listando todas as reservas
            for (ReservedBook reservedBook : user.getReservedBooks()) {
                System.out.println("Título: " + reservedBook.getTitle());
                System.out.println("Data da Solicitação: " + reservedBook.getDateBorrowed());
                System.out.println();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addObserver(String userCode, String bookCode) {
        try {
            Book book = getBook(bookCode);
            User user = getUser(userCode);
            
            //ERRADISSIMO
            Professor professor = (Professor) user;
            book.registerObserver(professor);
            System.out.println("O usuário " + userCode + " foi adicionado como observador do livro " + bookCode);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void notifyUser(String userCode) {
        try {
            User user = getUser(userCode);
            
            //ERRADISSIMO
            Professor professor = (Professor) user; // Fazendo o cast para Professor
            System.out.println("O professor " + userCode + " foi notificado " + professor.getTimesNotified() + " vezes");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
