package practica1.gestordeportivo.models.lists;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

   public BufferedWriter createTeamsFile() {
      try {
         File teamsFile = new File("teamFile.txt");
         teamsFile.createNewFile();
         FileWriter fw = new FileWriter(teamsFile);
         BufferedWriter bw = new BufferedWriter(fw);

         return bw;
      } catch (IOException ex) {
         ex.getMessage();
         return null;
      }
   }
}
