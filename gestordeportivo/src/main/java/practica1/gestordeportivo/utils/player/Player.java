package practica1.gestordeportivo.utils.player;

public class Player {

    private final String name;
    private double score;
    private boolean matched;

    //revisar assert
    public Player(String name) {
        assert !name.isBlank() && 
                name.length() >= 2 && 
                Character.isUpperCase(name.charAt(0)) && 
                !name.matches(".*\\d.*") :
                "ERROR: formato incorrecto en el nombre especificcado. ";
        this.name = name;
        score = 0.0;
        matched = false;
    }

    //revisar assert
    public Player(String name, double score) {
        assert !name.isBlank() && 
                name.length() >= 2 && 
                Character.isUpperCase(name.charAt(0)) && 
                !name.matches(".*\\d.*") :
                "ERROR: formato incorrecto en el nombre especificcado. ";
        this.name = name;
        this.score = score;
        matched = false;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    //revisar assert
    public void setScore(double score) {
        assert score >= -999999.0 : "ERROR: valor demasiado pequeño";
        this.score = score;
    }

    public void setMatched(boolean stat) {
        matched = stat;
    }

    public boolean getMatched() {
        return matched;
    }

    public String toString() {
        return "Usuario: " + this.name + ". Puntuación: " + this.score;
    }

}