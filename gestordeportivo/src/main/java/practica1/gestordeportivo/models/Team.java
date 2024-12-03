package practica1.gestordeportivo.models;

import java.util.ArrayList;

public class Team {
    
    private String name;
    private ArrayList<Player> members;
    private Statistics stats;

    public Team(String name) {
        this.name = name;
        stats = new Statistics();
        members = new ArrayList<>();
    }

    public void updateStats() {
        if(!members.isEmpty()) {
            for (int i = 0; i < stats.getStats().length; i++) {
                for (int j = 0; j < members.size(); j++) {
                    stats.getStats()[i] += members.get(j).getStats().getStat(i);
                }
                stats.getStats()[i] /= members.size();
            }
        }       
    }
    
}