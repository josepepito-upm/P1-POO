package practica1.gestordeportivo.commands;

import java.util.ArrayList;
import practica1.gestordeportivo.controllers.UserController;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.types.Role;
import practica1.gestordeportivo.views.TournamentListView;
import practica1.gestordeportivo.models.lists.TournamentList;
import practica1.gestordeportivo.models.Tournament;
public class ListTournaments extends PublicCommands {

    public ListTournaments(UserController userController) {
        super(userController); 
    }
    
    TournamentListView tournamentListView = new TournamentListView();
    TournamentList tournamentList = userController.getCli().getTournamentList();
    ArrayList<Tournament> orderedTournaments;

    public Errors validate(String command){
        super.validate(command);

        if (command != "tournament-list") {
            return Errors.FORMAT_ERROR; 
        }
        return Errors.NULL;  
    }

    public Errors execute(String command) {
        if(validate(command).isNull()) {
            switch(userController.getCli().getAuthenticatedUser().getRole()) {
                case Role.ADMIN: 
                    setOrderedTournaments(tournamentList.getTournaments());
                    removeFinished(orderedTournaments);
                    break;
                case Role.PLAYER: 
                    setOrderedTournaments(tournamentList.getTournaments());
                    break;
                case Role.GUEST: 
                    setOrderedTournaments(tournamentList.randomOrder());    
                    break;
            }
            return Errors.NULL;
        } else return validate(command);
    }

    public ArrayList<Tournament> getOrderedTournaments() {
        return orderedTournaments;
    }
    private void setOrderedTournaments(ArrayList<Tournament> tournaments) {
        orderedTournaments = tournaments;
    }
    private void removeFinished(ArrayList<Tournament> tournaments) {
        for (Tournament tournament : tournaments) {
            tournament.setInProgress();
            if(!tournament.isInProgress()) 
                tournaments.remove(tournament);
        }    
    }
}
