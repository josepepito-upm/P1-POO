package practica1.gestordeportivo.views;

import practica1.gestordeportivo.models.Player;

public class PlayerView extends View {
    private Player player;
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void view() {
        System.out.println("Nombre: " + player.getForename() + player.getSurname() + ". ID: " + player.getId());
    }
}
