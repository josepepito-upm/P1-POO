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

   public ArrayList<Tournament> randomOrder() {
      ArrayList<Tournament> ordered = new ArrayList<Tournament>();
      int previousIndex = -1, added = 0;
      while(added < tournaments.size()) {
         int randomIndex = (int)(Math.random()*tournaments.size());
         if(previousIndex == -1 || previousIndex != randomIndex) {
            ordered.add(tournaments.get(randomIndex));
            added++;
            previousIndex = randomIndex;
         }
      }
          
      return ordered;
   }
   
}
