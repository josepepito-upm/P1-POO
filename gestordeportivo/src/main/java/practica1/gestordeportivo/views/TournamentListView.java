package practica1.gestordeportivo.views;

import java.util.ArrayList;
import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.models.Tournament;

public class TournamentListView {
    public void show(CommandLineInterpreter cli) {
        ArrayList<Tournament> tournaments = cli.getTournamentList().getTournaments();
        TournamentView tournamentView = new TournamentView();
        PlayerView playerView = new PlayerView();

        for (Tournament tournament : tournaments) {
            tournamentView.setTournament(tournament);
            tournamentView.view();
            for (Player player : tournament.getParticipants()) {
                playerView.setPlayer(player);
                playerView.view();
            }
        }
        
    }
    
}