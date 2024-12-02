package practica1.gestordeportivo.models;

public class Player extends User {

    private final String forename; // Nombre del jugador
    private final String surname;  // Apellido del jugador
    private final String id;       // Identificación del jugador
    private boolean matched;       // Estado de emparejamiento
    private double score;          // Puntuación del jugador
    private Statistics stats;      // Estadísticas del jugador

    // Constructor para inicializar forename y score
    public Player(String username, String password, String forename) {
        super(username, password); // Llama al constructor de User
        if (forename.isBlank() || 
            forename.length() < 2 || 
            !Character.isUpperCase(forename.charAt(0)) || 
            forename.matches(".*\\d.*")) {
            throw new IllegalArgumentException("ERROR: formato incorrecto en el nombre especificado.");
        }
        this.forename = forename;
        this.surname = "";  // O inicializa según la lógica de tu aplicación
        this.id = "";       // O inicializa según la lógica de tu aplicación
        this.score = 0.0;
        this.matched = false;
        this.stats = new Statistics();
    }

    public Player(String username, String password, String forename, double score) {
        super(username, password); // Llama al constructor de User
        if (forename.isBlank() || 
            forename.length() < 2 || 
            !Character.isUpperCase(forename.charAt(0)) || 
            forename.matches(".*\\d.*")) {
            throw new IllegalArgumentException("ERROR: formato incorrecto en el nombre especificado.");
        }
        this.forename = forename;
        this.surname = "";  // O inicializa según la lógica de tu aplicación
        this.id = "";       // O inicializa según la lógica de tu aplicación
        this.score = score;
        this.matched = false;
        this.stats = new Statistics();
    }

    public String getForename() {
        return forename;
    }

    public Statistics getStats() {
        return stats;
    }

    public void setMatched(boolean stat) {
        matched = stat;
    }

    public boolean getMatched() {
        return matched;
    }

    @Override
    public String toString() {
        return "Usuario: " + this.forename + ". Puntuación: " + this.score;
    }

    // Método getName: devuelve el forename
    public String getName() {
        return this.forename;
    }

    // Método getScore: devuelve el score
    public double getScore() {
        return this.score;
    }
}