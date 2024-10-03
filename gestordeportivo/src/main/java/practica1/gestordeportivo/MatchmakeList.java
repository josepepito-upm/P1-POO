package practica1.gestordeportivo;

public class MatchmakeList {

    private Matchmake[] matchmakes;
    private int size;
    
    public MatchmakeList() {
        size = 5;
        matchmakes = new Matchmake[size];
    }

    public void add(Player p1, Player p2) {
        int count = 0;

        assert p1.getStatus() == true && p2.getStatus() == true : "ERROR: uno de los jugadores ya está emparejado.";
        while(count < matchmakes.length) {
            if(matchmakes[count] == null) {
                matchmakes[count] = new Matchmake(p1, p2);
                p1.setMatchmakingTrue();
                p2.setMatchmakingTrue();
            }
            count++;
        }
        this.resize(count);
    }

    private void resize(int index) {
        if (index == matchmakes.length) {
           int aux = size + 5;
           Matchmake[] auxMatchmakes = new Matchmake[aux];
           for (int i = 0; i < matchmakes.length ; i++) {
              auxMatchmakes[i] = matchmakes [i]; 
           }
     
           size = aux;
           matchmakes = auxMatchmakes;
        } 
     }

    public void show() {
        for (int i = 0; i < matchmakes.length; i++) {
            System.out.println(matchmakes[i]);
        }
    }

    public void clear() {
        matchmakes = null;
    }

    public void random() {
        for (int i = 0; i < matchmakes.length; i++) {
        }
        assert .... % 2 != 0 : "ERROR: número de jugadores impar.";
    }
}
