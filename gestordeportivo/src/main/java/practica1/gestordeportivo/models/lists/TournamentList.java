package practica1.gestordeportivo.models.lists;

import java.util.ArrayList;

import practica1.gestordeportivo.models.Tournament;

public class TournamentList {
    
   private ArrayList<Tournament> tournaments;

   public ArrayList<Tournament> getTournaments() {
      return tournaments;
   }

   public Tournament getTournament(String name) {
      for (Tournament tournament : tournaments) {
         if (tournament.getName().equals(name)) {
            return tournament;
         }
      }
      return null;
   }
}
