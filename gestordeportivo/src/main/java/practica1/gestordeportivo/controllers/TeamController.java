package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.models.Team;
import practica1.gestordeportivo.views.Message;

public class TeamController {
    
    protected CommandLineInterpreter cli;
    private Message message;

    public TeamController (CommandLineInterpreter cli) {
        this.cli = cli;
    }

    public void create(String[] TeamData) {
        cli.getTeamList().add(new Team(teamData));
        message.writeMessage(Message.TEAM_CREATED);
    }

    public void delete(String name) {
        cli.getTeamList().remove(name);
        message.writeMessage(Message.TEAM_DELETED);
    }

    public void add(Player player, Team team) {

    }

    public void remove(Player player, Team team) {
        
    }

}
