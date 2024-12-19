package practica1.gestordeportivo.views;

import java.io.Console;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.controllers.TeamController;
import practica1.gestordeportivo.controllers.TournamentController;
import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.types.Errors;

public class CLIView {

    private final CommandLineInterpreter cli;
    private final UserController userController;
    private final PlayerController playerController;
    private final TeamController teamController;
    private final TournamentController tournamentController;

    private final ErrorView errorView;
    private final String prompt = "~>";
    private final Console console = System.console();


    public UserController getUserController(){
        return userController;
    }

    public PlayerController getPlayerController(){
        return playerController;
    }

    public TeamController getTeamController(){
        return teamController;
    }

    public TournamentController getTournamentController(){
        return tournamentController;
    }
    public CLIView(CommandLineInterpreter cli) {
    
        this.userController = new UserController();
        this.playerController = new PlayerController();
        this.teamController = new TeamController();
        this.tournamentController = new TournamentController();
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