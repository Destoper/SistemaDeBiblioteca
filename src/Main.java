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

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        // Adicionando cópias dos livros
        book1.addCopy(BookFactory.createBookCopy(book1));
        book1.addCopy(BookFactory.createBookCopy(book1));
        book2.addCopy(BookFactory.createBookCopy(book2));
        book3.addCopy(BookFactory.createBookCopy(book3));
        book4.addCopy(BookFactory.createBookCopy(book4));

        LibraryConsole console = LibraryConsole.getInstance(library);
        console.start(); // Inicia a leitura de comandos
//
//        // Configurando comandos na LibraryConsole
//        LibraryConsole console = LibraryConsole.getInstance();
//
//        // Registrar comandos para empréstimo e devolução
//        console.registerCommand("emp", new LoanCommand(library, "123", "100"));  // Empréstimo do livro 100 para o usuário 123
//        //console.registerCommand("dev", new ReturnCommand(library, "123", "100")); // Devolução do livro 100 pelo usuário 123
//        console.executeCommand("emp");
//        console.registerCommand("emp", new LoanCommand(library, "123", "101"));
//        console.executeCommand("emp");
//        console.registerCommand("emp", new LoanCommand(library, "123", "200"));
//        console.executeCommand("emp");
////        console.registerCommand("dev", new ReturnCommand(library, "123", "100"));
////        console.executeCommand("dev");
//        console.registerCommand("emp", new LoanCommand(library, "123", "201"));
//        console.executeCommand("emp");



//        console.registerCommand("emp", new LoanCommand(library, "100", "100"));
//        console.executeCommand("emp");
//
//        console.registerCommand("emp", new LoanCommand(library, "100", "101"));
//        console.executeCommand("emp");
//
//        console.registerCommand("emp", new LoanCommand(library, "100", "200"));
//        console.executeCommand("emp");
//
//        console.registerCommand("emp", new LoanCommand(library, "100", "201"));
//        console.executeCommand("emp");




    }
}
