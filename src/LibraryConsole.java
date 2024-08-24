import java.util.HashMap;
import java.util.Map;

public class LibraryConsole {
    private Map<String, Command> commands;

    private static LibraryConsole instance;

    private LibraryConsole() {
        commands = new HashMap<>();
    }

    public static LibraryConsole getInstance() {
        if (instance == null) {
            instance = new LibraryConsole();
        }
        return instance;
    }

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void executeCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Comando não encontrado.");
        }
    }
}
