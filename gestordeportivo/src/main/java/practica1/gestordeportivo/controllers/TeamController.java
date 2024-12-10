package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.Team;

public class TeamController extends Controller{

    public void create(String name) {
        Team team = new Team(name);
        getCli().getTeamList().getTeams().add(team);
    }

    public void delete(Team team) {
        getCli().getTeamList().getTeams().remove(team);
    }

    public void add(String id, String teamName) {
        getCli().getTeamList().getTeam(teamName).getMembers().add(cli.getPlayerList().getPlayer(id));
    }

    public void remove(String id, String teamName) {
        getCli().getTeamList().getTeam(teamName).getMembers().remove(cli.getPlayerList().getPlayer(id));
    }

}
