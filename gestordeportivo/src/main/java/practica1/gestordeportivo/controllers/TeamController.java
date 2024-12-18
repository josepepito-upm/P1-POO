package practica1.gestordeportivo.controllers;

import java.io.BufferedWriter;
import java.io.IOException;

import practica1.gestordeportivo.models.CommandLineInterpreter;
import practica1.gestordeportivo.models.Team;

public class TeamController extends Controller{

    public TeamController(CommandLineInterpreter cli) {
        super(cli);
    }

    public void create(String name) {
        Team team = new Team(name);
        getCli().getTeamList().getTeams().add(team);
    }

    public void delete(Team team) {
        getCli().getTeamList().getTeams().remove(team);
    }

    public void add(String id, String teamName) {
        getCli().getTeamList().getTeam(teamName).getMembers().add(getCli().getPlayerList().getPlayer(id));
    }

    public void remove(String id, String teamName) {
        getCli().getTeamList().getTeam(teamName).getMembers().remove(getCli().getPlayerList().getPlayer(id));
    }

    public void saveAllTeams() {
        BufferedWriter bwTeam = getCli().getTeamList().createTeamsFile();

        for(Team team : getCli().getTeamList().getTeams()) {
            try {
                bwTeam.write(team.getName());
                bwTeam.newLine();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    public void recoverAllTeams() {

    }

}
