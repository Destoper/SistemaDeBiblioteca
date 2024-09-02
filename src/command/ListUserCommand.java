package command;
import system.*;
public class ListUserCommand implements ICommand {

    private final Library library;
    private String userCode;

    public ListUserCommand(Library library, String userCode) {
        this.library = library;
        this.userCode = userCode;
    }

    public void execute() {
        library.listUser(userCode);
    }
}