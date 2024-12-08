package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.Team;
import practica1.gestordeportivo.views.Message;

public class TeamController extends Controller{
    //Message va a views 
    private Message message;

    public void create(String name) {
        Team team = new Team(name);
        getCli().getTeamList().getTeams().add(team);
        message.writeMessage(Message.TEAM_CREATED);
    }

    public void delete(Team team) {
        getCli().getTeamList().getTeams().remove(team);
        message.writeMessage(Message.TEAM_DELETED);
    }

    public void add(String id, String teamName) {
        getCli().getTeamList().getTeam(teamName).getMembers().add(cli.getPlayerList().getPlayer(id));
        message.writeMessage(Message.PLAYER_ADDED_TEAM);
    }

    public void remove(String id, String teamName) {
        getCli().getTeamList().getTeam(teamName).getMembers().remove(cli.getPlayerList().getPlayer(id));
        message.writeMessage(Message.PLAYER_REMOVED_TEAM);
    }

}
