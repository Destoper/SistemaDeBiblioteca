package command;

import system.Library;

public class NotifyCommand  implements ICommand {
    private Library library;
    private String userCode;

    public NotifyCommand(Library library, String userCode) {
        this.library = library;
        this.userCode = userCode;
    }

    @Override
    public void execute() {
        library.notifyUser(userCode);
    }
    
}
