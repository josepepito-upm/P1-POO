package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.Tournament;

public class TournamentController extends Controller{
    
    public void create(String name, String startDate, String endDate, String league, String sport) {
        getCli().getTournamentList().getTournaments().add(new Tournament(name, startDate, endDate, league, sport));
    }

    public void delete(Tournament tournament) {
        getCli().getTournamentList().getTournaments().remove(tournament);
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
        getCli().getTournamentList().getTournament(tournament).getParticipants().add(getCli().getAuthenticatedPlayer());
    }

    public void removePlayer(String tournament) {
        getCli().getTournamentList().getTournament(tournament).getParticipants().remove(getCli().getAuthenticatedPlayer()); 
    }
}
