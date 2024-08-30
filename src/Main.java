public class Main {
    public static void main(String[] args) {
        // Criação da biblioteca
        Library library = new Library();

        // Criando e adicionando usuários
        User user1 = new GradStudent("123", "João da Silva", new StudentLoanStrategy());
        User user2 = new PostGradStudent("456", "Luiz Fernando Rodrigues", new StudentLoanStrategy());
        User user3 = new GradStudent("789", "Pedro Paulo", new StudentLoanStrategy());
        User user4 = new Professor("100", "Carlos Lucena", new ProfessorLoanStrategy());

        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);
        library.addUser(user4);

        // Criando e adicionando livros
        Book book1 = BookFactory.createBook("100", "Engenharia de Software", "Ian Sommerville", "Addison-Wesley", "2000", "6ª");
        Book book2 = BookFactory.createBook("101", "UML – Guia do Usuário", "Grady Booch, James Rumbaugh, Ivar Jacobson", "Campus", "2000", "7ª");
        Book book3 = BookFactory.createBook("200", "Code Complete", "Steve McConnell", "Microsoft Press", "2014", "2ª");
        Book book4 = BookFactory.createBook("201", "Agile Software Development", "Robert Martin", "Prentice Hall", "2002", "1ª");
        Book book5 = BookFactory.createBook("300", "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "AddisonWesleyProfessional", "1999", "1ª");
        Book book6 = BookFactory.createBook("301", "Software Metrics: A Rigorous and Practical Approach", "Norman Fenton, James Bieman", "CRC Press ", "1999", "3ª");
        Book book7 = BookFactory.createBook("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "AddisonWesleyProfessional", "1994", "1ª");
        Book book8 = BookFactory.createBook("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Martin Fowler", "AddisonWesleyProfessional", "2003", "3ª");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);

        // Adicionando cópias dos livros
        book1.addCopy(BookFactory.createBookCopy(book1));
        book1.addCopy(BookFactory.createBookCopy(book1));
        book2.addCopy(BookFactory.createBookCopy(book2));
        book3.addCopy(BookFactory.createBookCopy(book3));
        book4.addCopy(BookFactory.createBookCopy(book4));
        book5.addCopy(BookFactory.createBookCopy(book5));
        book6.addCopy(BookFactory.createBookCopy(book6));
        book7.addCopy(BookFactory.createBookCopy(book7));
        book8.addCopy(BookFactory.createBookCopy(book8));

        LibraryConsole console = LibraryConsole.getInstance(library);
        console.start(); // Inicia a leitura de comandos




    }
}
