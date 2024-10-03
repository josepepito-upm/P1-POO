package practica1.gestordeportivo;

public class Matchmake {

    private Player[] matchmake;

    public Matchmake(Player player1, Player player2) {
        this.matchmake = new Player[2];
        this.matchmake[0] = player1;
        this.matchmake[1] = player2;
    }

    public String toString() {
        return matchmake[0].getName() + " vs " + matchmake[1].getName();
    }
    
}
