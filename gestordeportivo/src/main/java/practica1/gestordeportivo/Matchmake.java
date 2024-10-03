package practica1.gestordeportivo;

public class Matchmake {

    Player p1;
    Player p2;

    public Matchmake(Player p1, Player p2) {
        this.p1 = p1;
            p1.setMatchmakingTrue();
        this.p2 = p2;
            p2.setMatchmakingTrue();        
    }

    public String toString() {
        return p1.getName() + "(" + p1.getScore() + ") vs. " + p2.getName() + "(" + p2.getScore() + ")";
    }
    
}