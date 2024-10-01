package practica1.gestordeportivo;

public class Player {

    private String name;
    private double score;

    public Player(String name) {
        assert !(name.isBlank()) &&
                name.length() > 3 &&
                Character.isUpperCase(name.charAt(0)) :
                "ERROR: formato incorrecto en el nombre especificcado. ";
        this.name = name;
        score = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        assert score >= -999999.0 : "ERROR: valor demasiado pequeño";
        this.score = score;
    }

    public String toString() {
        return "Usuario : " + this.name + ". Puntuación: " + this.score;
    }

}