package practica1.gestordeportivo;

public class MatchmakeList {

    private Matchmake[] matchmakes;
    private int size;
    private int numMatchmakes;

    public MatchmakeList() {
        size = 5;
        matchmakes = new Matchmake[size];
        numMatchmakes = 0;
    }

    public void match(Player p1, Player p2) {
        int count = 0;

        assert p1.getStatus() == false && p2.getStatus() == false : "ERROR: uno de los jugadores ya está emparejado.";
        while (count < matchmakes.length) {
            if (matchmakes[count] == null) {
                matchmakes[count] = new Matchmake(p1, p2);
            }
            numMatchmakes++;
        }
        this.resize();
    }

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

    public void show() {
        for (int i = 0; i < numMatchmakes; i++) {
            System.out.println(matchmakes[i]);
        }
    }

    public void clear() {
        for (int i = 0; i < matchmakes.length; i++) {
            matchmakes[i].unmatch();
            matchmakes[i] = null;
        }
        numMatchmakes = 0;
    }

    public int getNumMatchamakes() {
        return numMatchmakes;
    }

    public void random() {
        
        /** Rubén: De esto se encarga Alex:
         * 
         *  assert players.getNumPlayers() % 2 != 0 : "ERROR: número de jugadores impar.";

            clear();
            while (numMatchmakes != players.getNumPlayers() / 2) {
                matchmakes.add(players[(int) (Math.random() * numPlayers)], players[(int) (Math.random() * numPlayers)]);
                numMatchmakes++;
            }
         * 
         * 
         * 
        */
    }
}
