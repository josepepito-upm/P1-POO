package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.views.CLIView;
import practica1.gestordeportivo.views.Message;

public class TournamentController {
    
    protected CommandLineInterpreter cli;
    private CLIView cliView;
    private Message message;

    private String name;
    private String startDate;
    private String endDate;
    private String league;
    private String sport;
    
    public TournamentController (CommandLineInterpreter cli) {
        this.cli = cli;
    }

    public void create(String name, String startDate, String endDate, String league, String sport) {
        cli.getTournamentList().getTournaments().add(new Tournament(name, startDate, endDate, league, sport));
        message.writeMessage(Message.TOURNAMENT_CREATED);
    }

    public void delete(String tournamentName) {
        Tournament tournament = getTournament(tournamentName);
        cli.getTournamentList().getTournaments().remove(tournament);
        message.writeMessage(Message.TOURNAMENT_DELETED);
    }

    private Tournament getTournament(String tournamentName) {
        for (Tournament tournament : cli.getTournamentList().getTournaments()) {
            if (tournament.getName().equalsIgnoreCase(tournamentName)) {
                return tournament;
            }
        }
        return null; // Si no se encuentra el torneo, retornamos null
    }

    public void addPlayer(String tournament) {
        cli.getTournamentList().getTournament(tournament).getParticipants().add(/*añadir jugador autenticado */); 
        message.writeMessage(Message.PLAYER_ADDED);
    }

    public void removePlayer(String tournament) {
        cli.getTournamentList().getTournament(tournament).getParticipants().remove(/*añadir jugador autenticado */); 
        message.writeMessage(Message.PLAYER_REMOVED);
    }

    public void list() {
        //toString de las estadisticas del jugador autenticado
    }
}
