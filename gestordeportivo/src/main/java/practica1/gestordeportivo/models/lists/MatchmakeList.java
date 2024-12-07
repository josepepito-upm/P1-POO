package practica1.gestordeportivo.models.lists;

import java.util.ArrayList;

import practica1.gestordeportivo.models.Matchmake;

public class MatchmakeList {
    
    private ArrayList<Matchmake> matchmakes;

    public MatchmakeList() {
        matchmakes = new ArrayList<>();
    }

    public void add(Matchmake match) {
        matchmakes.add(match);
    }

    public int getNumMatchmakes() {
        return matchmakes.size();
    }
}
