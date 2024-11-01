package practica1.gestordeportivo.utils.matchmake;

import practica1.gestordeportivo.utils.player.Player;
import practica1.gestordeportivo.utils.player.PlayerList;

public class MatchmakeList {
//cambiar array por lista (?)
    private Matchmake[] matchmakes; //se cambia por private List<Matchmake> matchmakes;
    private int size; //desaparece
    private int numMatchmakes; //desaparece

    //se cambia por el constructor de la lista
    public MatchmakeList() {
        size = 5;
        matchmakes = new Matchmake[size];
        numMatchmakes = 0;
    }

    //rehacer para listas + assert
    public void match(Player p1, Player p2) {
        int count = 0;
        boolean matched = false;
        assert p1.getMatched() == false && p2.getMatched() == false : "ERROR: uno de los jugadores ya está emparejado.";
        while (count < matchmakes.length && !matched) {
            if (matchmakes[count] == null) {
                matchmakes[count] = new Matchmake(p1, p2);
                numMatchmakes++;
                matched = true;
            } else {
                count++;
            }
            
        }
        this.resize();
    }

    //desaparece
    private void resize() {
        if (numMatchmakes == matchmakes.length) {
            int aux = size + 5;
            Matchmake[] auxMatchmakes = new Matchmake[aux];
            for (int i = 0; i < matchmakes.length; i++) {
                auxMatchmakes[i] = matchmakes[i];
            }
            size = aux;
            matchmakes = auxMatchmakes;
        }
    }

    //rehacer para listas (no se si hay comando de la api de java para esto)
    public void show() {
        for (int i = 0; i < numMatchmakes; i++) {
            System.out.println(matchmakes[i]);
        }
    }

    //desaparece (hay un metodo clear en la api de java)
    public void clear() {
        for (int i = 0; i < matchmakes.length; i++) {
            if(matchmakes[i] != null) {
                matchmakes[i].unmatch();
                matchmakes[i] = null;
            }
        }
        numMatchmakes = 0;
    }

    //desaparece
    public int getNumMatchamakes() {
        return numMatchmakes;
    }

    //rehacer para listas + asserts
    public void random(PlayerList playerList) {
        Player[] allPlayers = playerList.getPlayers();
        int numPlayers = playerList.getNumPlayers();
        
        clear();
        
        assert numPlayers >= 2 : "ERROR: no hay suficientes jugadores desemparejados para emparejar.";
        assert numPlayers % 2 == 0 : "ERROR: número de jugadores desemparejados impar.";

        int numNewMatches = numPlayers / 2;
        for (int i = 0; i < numNewMatches; i++) {
            int pos1, pos2;
             
            do { 
                pos1 = (int)(Math.random() * numPlayers);
            } while (allPlayers[pos1] == null || allPlayers[pos1].getMatched());

            do { 
                pos2 = (int)(Math.random() * numPlayers);
            } while (allPlayers[pos2] == null || allPlayers[pos2].getMatched() || pos2 == pos1);
            
            match(allPlayers[pos1], allPlayers[pos2]);
        }  
    }
}
