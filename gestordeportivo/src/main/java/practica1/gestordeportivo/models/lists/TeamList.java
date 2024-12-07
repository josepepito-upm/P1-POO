package practica1.gestordeportivo.models.lists;

import java.util.ArrayList;

import practica1.gestordeportivo.models.Team;

public class TeamList {
    
    private ArrayList<Team> teams;

    public ArrayList<Team> getTeams() {
      return teams;
   }

   public Team getTeam(String name) {
      for (Team team : teams) {
         if (team.getName().equals(name)) {
            return team;
         }
      }
      return null;
   }
}
