package practica1.gestordeportivo;

public class Player {

    private String name;
    private double score;
    private boolean matched;

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

<<<<<<< HEAD
    public void setMatchedTrue () {
        matched = true;
    }

    public void setMatchedFalse() {
        matched = false;
    }
=======
    public void setMatchmaking(boolean stat) {
        matched = stat;
    }

>>>>>>> e11f5ee (cambios que hice ayer y no subí)

    public boolean getStatus() {
        return matched;
    }


    public String toString() {
        return "Usuario : " + this.name + ". Puntuación: " + this.score;
    }

}