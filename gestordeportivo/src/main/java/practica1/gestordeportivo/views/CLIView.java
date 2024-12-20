package practica1.gestordeportivo.views;

import java.io.Console;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.types.Commands;
import practica1.gestordeportivo.types.Errors;

public class CLIView {
    private CommandLineInterpreter cli;
    private Console console = System.console();
    private ErrorView errorView;
    private String prompt = "~>";


    public CLIView(CommandLineInterpreter cli) {
        this.cli = cli;
        this.errorView = new ErrorView(); 
    }
    public void initialize() {
        String command;
        do {
            
            new UserView(cli.getAuthenticatedUser()).view();
            System.out.print(prompt);

            command = console.readLine();
            if (command == null || command.trim().isEmpty()) {
                errorView.writeError(Errors.SYNTAX_ERROR); 
                continue;
            }
            getCommand(command);
        } while(!"exit".equalsIgnoreCase(command)); //PRUEBA (Falta definir que si el comando es exit no devuelva un comando no encontrado)
    }

    private void getCommand(String command) {
        Errors status = Commands.executeCommand(command, cli);
        if (!status.isNull()) { 
            errorView.writeError(status);
            return;
        }


    }
    
}