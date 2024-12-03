package practica1.gestordeportivo.models;

import practica1.gestordeportivo.models.lists.MatchmakeList;
import practica1.gestordeportivo.models.lists.PlayerList;
import practica1.gestordeportivo.models.lists.TeamList;
import practica1.gestordeportivo.models.lists.TournamentList;

public class CommandLineInterpreter {
    
    PlayerList playerList = new PlayerList();
    MatchmakeList matchmakeList;
    TeamList teamList;
    TournamentList tournamentList;

    public PlayerList getPlayerList() {
        return playerList;
    }

}
