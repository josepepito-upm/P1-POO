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

    //inscribe al jugador autenticado
    public void addPlayer(Tournament tournament) {

        message.writeMessage(Message.PLAYER_ADDED);
    }

    //inscribe al equipo del jugador autenticado
    public void addTeam(Tournament tournament) {

        message.writeMessage(Message.TEAM_ADDED);
    }

    public void removePlayer(Tournament tournament) {

        message.writeMessage(Message.PLAYER_REMOVED);
    }

    public void removeTeam(Tournament tournament) {

        message.writeMessage(Message.TEAM_REMOVED);
    }

    public void list() {
        
    }
}
