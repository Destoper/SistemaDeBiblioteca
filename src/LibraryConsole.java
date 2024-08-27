import java.util.Scanner;

public class LibraryConsole {
    private static LibraryConsole instance;
    private Scanner scanner;
    private Library library;

    private LibraryConsole(Library library) {
        scanner = new Scanner(System.in);
        this.library = library;
    }

    public static LibraryConsole getInstance(Library library) {
        if (instance == null) {
            instance = new LibraryConsole(library);
        }
        return instance;
    }

    public void start() {
        while (true) {
            System.out.print("Digite um comando: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String action = parts[0];

            if (action.equalsIgnoreCase("sai")) {
                System.out.println("Encerrando o sistema...");
                break;
            }

            executeCommand(action, parts);
        }
    }

    private void executeCommand(String action, String[] params) {
        Command command = null;

        switch (action.toLowerCase()) {
            case "emp":
                command = new LoanCommand(library, params[1], params[2]);

                break;
            case "dev":
                command = new ReturnCommand(library, params[1], params[2]);
                break;

            case "res":
                command = new ReserveCommand(library, params[1], params[2]);

                break;
//            case "obs":
//                if (params.length >= 3) {
//                    command = new ObserveCommand(library, params[1], params[2]);
//                }
//                break;
            // E assim por diante para outros comandos
            default:
                System.out.println("Comando não reconhecido!");
                break;
        }

        if (command != null) {
            command.execute();
        } else {
            System.out.println("Parâmetros insuficientes ou comando inválido.");
        }
    }
}
