package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.views.Message;

public class PlayerController {
   
    protected CommandLineInterpreter cli;
    private Message message;
    
    public PlayerController (CommandLineInterpreter cli) {
        this.cli = cli;
    }

    public void create(String[] playerData) {
        cli.getPlayerList().add(new Player(playerData));
        message.writeMessage(Message.PLAYER_CREATED);
    }

    public void delete(String name) {
        cli.getPlayerList().remove(name);
        message.writeMessage(Message.PLAYER_DELETED);
    }
}
