package practica1.gestordeportivo;

public class Player {
    private String name;
    private double score;

    public Player(String name) {
        this.name = name;
        score = Integer.MIN_VALUE;
    }
}