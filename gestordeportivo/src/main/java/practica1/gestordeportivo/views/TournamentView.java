package practica1.gestordeportivo.views;

import practica1.gestordeportivo.models.Tournament;

public class TournamentView extends View {
    private Tournament tournament;
    
    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void view() {
        System.out.println("Nombre: " + tournament.getName() + 
                            "\nFecha inicio: " + tournament.getStartDate() +
                            "\nFecha final: " + tournament.getEndDate() + 
                            "\nLiga: " + tournament.getleague() + 
                            "\nDeporte: " + tournament.getSport());
    }
}