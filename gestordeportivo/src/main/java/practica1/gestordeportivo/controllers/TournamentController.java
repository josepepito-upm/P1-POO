package practica1.gestordeportivo.controllers;

import practica1.gestordeportivo.models.Player;
import practica1.gestordeportivo.models.Tournament;
import practica1.gestordeportivo.views.CLIView;
import practica1.gestordeportivo.views.Message;

public class TournamentController extends Controller{
    
    private Message message; //va a views
    
    //Todos los writeMessage() irán en una clase view que se encargue de pasarlos por pantalla    

    //Este que mejor reciba un array de String y opere con eso.
    public void create(String name, String startDate, String endDate, String league, String sport) {
        getCli().getTournamentList().getTournaments().add(new Tournament(name, startDate, endDate, league, sport));
        message.writeMessage(Message.TOURNAMENT_CREATED);
    }

    public void delete(Tournament tournament) {
        getCli().getTournamentList().getTournaments().remove(tournament);
        message.writeMessage(Message.TOURNAMENT_DELETED);
    }

    public void addPlayer(String tournament) {
        getCli().getTournamentList().getTournament(tournament).getParticipants().add(new Player(tournament, tournament, tournament, tournament, tournament)); 
        message.writeMessage(Message.PLAYER_ADDED);
    }

    public void removePlayer(String tournament) {
        getCli().getTournamentList().getTournament(tournament).getParticipants().remove(getCli().getUser()); 
        message.writeMessage(Message.PLAYER_REMOVED);
    }

    public void list() {
        //toString de las estadisticas del jugador autenticado
    }
}
