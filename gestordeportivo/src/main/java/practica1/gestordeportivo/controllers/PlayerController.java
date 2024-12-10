package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.Player;

public class PlayerController extends Controller{
   
    public void create(String username, String password, String forename, String surname, String id) {
        Player player = new Player(username, password, forename, surname, id);
        getCli().getPlayerList().getPlayers().add(player);
        player.setCreator(getCli().getAuthenticatedAdmin());
    }

    public void delete(Player player) {
        getCli().getPlayerList().getPlayers().remove(player);
    }
}