package practica1.gestordeportivo.models;

import java.util.ArrayList;

public class Tournament {
    
    private final String name;
    private final String startDate;
    private final String endDate;
    private final String league;
    private final String sport;
    private boolean inProgress;
    private ArrayList<Player> participants;

    public Tournament(String name, String startDate, String endDate, String league, String sport) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.league = league;
        this.sport = sport;
        inProgress = false;
        participants = new ArrayList<>();
    }

    public Player getPlayer(String id) {
        for (Player player : participants) {
           if (player.getId().equals(id)) {
              return player;
           }
        }
        return null;
    }

    public ArrayList<Player> getParticipants() {
        return participants;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public String getName() {
        return name;
    }
}
