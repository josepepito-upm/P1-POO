package practica1.gestordeportivo.controllers;

import java.io.BufferedWriter;
import java.io.IOException;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Tournament;

public class TournamentController extends Controller{

    public TournamentController(CommandLineInterpreter cli) {
        super(cli);
    }
    
    public void create(String name, String startDate, String endDate, String league, String sport) {
        getCli().getTournamentList().getTournaments().add(new Tournament(name, startDate, endDate, league, sport));
    }

    public void delete(Tournament tournament) {
        getCli().getTournamentList().getTournaments().remove(tournament);
    }

    public void addPlayer(String tournament) {        
        getCli().getTournamentList().getTournament(tournament).getParticipants().add(getCli().getAuthenticatedPlayer());
    }

    public void removePlayer(String tournament) {
        getCli().getTournamentList().getTournament(tournament).getParticipants().remove(getCli().getAuthenticatedPlayer()); 
    }

    public void saveAllTournaments() {
        BufferedWriter bwTournament = getCli().getTournamentList().createTournamentsFile();

        for(Tournament tournament : getCli().getTournamentList().getTournaments()) {
            try {
                bwTournament.write(tournament.getName() + ", " + tournament.getleague() + ", " + tournament.getSport() + ", " +
                                    tournament.getStartDate() + ", " + tournament.getEndDate());
                bwTournament.newLine();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    public void recoverAllTournaments() {

    }
}
