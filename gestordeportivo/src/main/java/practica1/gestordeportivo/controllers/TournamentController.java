package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.views.Message;

public class TournamentController {
    
    protected CommandLineInterpreter cli;
    private Message message;
    
    public TournamentController (CommandLineInterpreter cli) {
        this.cli = cli;
    }

    public void create(String[] tournamentData) {
        cli.getTournamentList().add(new Tournament(tournamentData));
        message.writeMessage(Message.TOURNAMENT_CREATED);
    }

    public void delete(String name) {
        cli.getTournamentList().remove(name);
        message.writeMessage(Message.TOURNAMENT_DELETED);
    }
}
