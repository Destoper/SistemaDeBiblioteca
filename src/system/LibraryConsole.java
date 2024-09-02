package system;

import command.*;

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

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void start() {
        while (true) {
            System.out.print("[ :) ] Digite um comando: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String action = parts[0];

            if (action.equalsIgnoreCase("sai")) {
                System.out.println("[ :( ] Encerrando o sistema...");
                break;
            }

            executeCommand(action, parts);
        }
    }

    private void executeCommand(String action, String[] params) {
        ICommand command = null;

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
            case "obs":
                command = new ObserverCommand(library, params[1], params[2]);
                break;
            case "liv":
                command = new ListBookCommand(library, params[1]);
                break;
            case "usu":
                command = new ListUserCommand(library, params[1]);
                break;
            case "ntf":
                command = new NotifyCommand(library, params[1]);
                break;
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
