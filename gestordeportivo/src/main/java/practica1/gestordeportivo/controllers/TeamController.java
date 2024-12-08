package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Team;
import practica1.gestordeportivo.views.Message;

public class TeamController {
    
    protected CommandLineInterpreter cli;
    private Message message;

    public TeamController (CommandLineInterpreter cli) {
        this.cli = cli;
    }

    public void create(String name) {
        Team team = new Team(name);
        cli.getTeamList().getTeams().add(team);
        message.writeMessage(Message.TEAM_CREATED);
    }

    public void delete(String name) {
        Team team = new Team(name);
        cli.getTeamList().getTeams().remove(team);
        message.writeMessage(Message.TEAM_DELETED);
    }

    public void add(String id, String teamName) {
        cli.getTeamList().getTeam(teamName).getMembers().add(cli.getPlayerList().getPlayer(id));
        message.writeMessage(Message.PLAYER_ADDED_TEAM);
    }

    public void remove(String id, String teamName) {
        cli.getTeamList().getTeam(teamName).getMembers().remove(cli.getPlayerList().getPlayer(id));
        message.writeMessage(Message.PLAYER_REMOVED_TEAM);
    }

}
