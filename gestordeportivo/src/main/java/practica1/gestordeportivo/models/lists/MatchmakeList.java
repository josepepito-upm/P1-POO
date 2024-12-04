package practica1.gestordeportivo.models.lists;

import practica1.gestordeportivo.models.Matchmake;
import practica1.gestordeportivo.models.Player;
import java.util.ArrayList;
import java.util.List;

public class MatchmakeList {
//cambiar array por lista (?)
    private ArrayList<Matchmake> matchmakes;

    public MatchmakeList() {
        matchmakes = new ArrayList<>();
    }

    public void add(Matchmake match) {
        matchmakes.add(match);
    }

    //rehacer para listas + assert
    public void match(Player p1, Player p2) {
        assert !p1.getMatched() && !p2.getMatched() : "ERROR: uno de los jugadores ya está emparejado.";
        matchmakes.add(new Matchmake(p1, p2));
    }


    //rehacer para listas (no se si hay comando de la api de java para esto)
    public void show() {
        for (Matchmake matchmake : matchmakes) {
            System.out.println(matchmake);
        }
    }

    //desaparece (hay un metodo clear en la api de java)
    public void clear() {
        for (Matchmake matchmake : matchmakes) {
            matchmake.unmatch();
        }
        matchmakes.clear();
    }


    public void random(PlayerList playerList) {
        List<Player> unmatchedPlayers = new ArrayList<>();
        for (Player player : playerList.getPlayers()) {
            if (!player.getMatched()) {
                unmatchedPlayers.add(player);
            }
        }

        int numPlayers = unmatchedPlayers.size();
        clear();

        assert numPlayers >= 2 : "ERROR: no hay suficientes jugadores desemparejados para emparejar.";
        assert numPlayers % 2 == 0 : "ERROR: número de jugadores desemparejados impar.";

        while (!unmatchedPlayers.isEmpty()) {
            // Seleccionar dos jugadores al azar
            int pos1 = (int) (Math.random() * unmatchedPlayers.size());
            Player p1 = unmatchedPlayers.remove(pos1);

            int pos2 = (int) (Math.random() * unmatchedPlayers.size());
            Player p2 = unmatchedPlayers.remove(pos2);

            // Emparejar y agregar
            match(p1, p2);
        }
    }

    public int getNumMatchmakes() {
        return matchmakes.size();
    }
}
