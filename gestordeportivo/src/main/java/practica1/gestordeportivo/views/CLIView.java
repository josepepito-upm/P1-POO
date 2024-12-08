package practica1.gestordeportivo.views;

import java.io.Console;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.types.Errors;

public class CLIView {
    private CommandLineInterpreter cli;
    private Console console = System.console();
    private ErrorView errorView;
    private String prompt = "~>";

    public void initialize() {
        cli = new CommandLineInterpreter();
        String command;
        do {
            System.out.println(cli.getAuthenticatedUser().toString() + prompt); 
            command = console.readLine();
            getCommand(command);
        } while(!command.equals("exit"));
    }

    private void getCommand(String command) {
        System.out.println(prompt);
        Errors status = cli.executeCommand(command);
        errorView.writeError(status);
        if(status.isNull()) {
            if(command.equals("list-tournament"))
                new TournamentListView().show(cli);
            else new MessageView().showMessage(command);
        }
    }
    
}