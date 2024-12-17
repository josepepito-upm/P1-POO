package practica1.gestordeportivo.views;

import java.io.Console;

import practica1.gestordeportivo.models.CommandLineInterpreter;
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
            System.out.println("Usuario autenticado en CLIView: " + cli.getAuthenticatedUser());//PRUEBA
            System.out.println(cli.getAuthenticatedUser().toString() + prompt); 
            command = console.readLine();
            if (command == null || command.trim().isEmpty()) {
                errorView.writeError(Errors.SYNTAX_ERROR); 
                continue;
            }
            getCommand(command);
        } while(!"exit".equalsIgnoreCase(command)); //PRUEBA
    }

    private void getCommand(String command) {
        System.out.println(prompt);
        Errors status = cli.executeCommand(command);
        
        if (!status.isNull()) { 
            errorView.writeError(status);
            return;
        }


    }
    
}