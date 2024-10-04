package practica1.gestordeportivo;

public class Matchmake {

    Player p1;
    Player p2;

    public Matchmake(Player p1, Player p2) {
        this.p1 = p1;
            p1.setMatchedTrue();
        this.p2 = p2;
            p2.setMatchedTrue();        
    }

    public String toString() {
        return p1.getName() + "(" + p1.getScore() + ") vs. " + p2.getName() + "(" + p2.getScore() + ")";
    }
    
}