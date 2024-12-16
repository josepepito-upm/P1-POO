package practica1.gestordeportivo.views;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.types.Errors;

public class CLIView {
    private CommandLineInterpreter cli;
    private Console console = System.console();
    private ErrorView errorView;
    private String prompt = "~>";
    private final Map<String, Runnable> commandActions = new HashMap<>();//prueba


    public CLIView() {
        this.errorView = new ErrorView(); 
        commandActions.put("list-tournament", () -> new TournamentListView().show(cli));
        commandActions.put("default", () -> new MessageView().showMessage("Comando no reconocido."));
    }
    public void initialize() {
        cli = new CommandLineInterpreter();
        String command;
        do {
            System.out.println("Usuario autenticado actual: " + cli.getAuthenticatedUser());//PRUEBA
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

        commandActions.getOrDefault(command, commandActions.get("default")).run();

    }
    
}