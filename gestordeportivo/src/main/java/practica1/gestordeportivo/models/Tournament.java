package practica1.gestordeportivo.models;

import java.util.ArrayList;
import java.util.Calendar;
public class Tournament {
    
    private final String name;
    private String startDate;
    private String endDate;
    private final String league;
    private final String sport;
    private boolean inProgress;
    private ArrayList<Player> participants;

    public Tournament(String name, String startDate, String endDate, String league, String sport) {
        checkDates();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.league = league;
        this.sport = sport;
        inProgress = false;
        participants = new ArrayList<Player>();
    }

    public Player getPlayer(String id) {
        for (Player player : participants) {
           if (player.getId().equals(id)) {
              return player;
           }
        }
        return null;
    }

    public String getSport(){
        return sport;
    }
    public ArrayList<Player> getParticipants() {
        return participants;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress() { 
        Calendar date = Calendar.getInstance();
        int[] actualDate = {date.get(Calendar.DAY_OF_MONTH), 
                            date.get(Calendar.MONTH),
                            date.get(Calendar.YEAR)};
        int[] startDateInt = format(startDate);
        int[] endDateInt = format(endDate); 
    
        if((startDateInt[0] < actualDate[0] && startDateInt[1] < actualDate[1] && startDateInt[2] < actualDate[2]) && 
            (endDateInt[0] < actualDate[0] && endDateInt[1] < actualDate[1] && endDateInt[2] < actualDate[2]) ||
            (startDateInt[0] > actualDate[0] && startDateInt[1] > actualDate[1] && startDateInt[2] > actualDate[2]) && 
            (endDateInt[0] > actualDate[0] && endDateInt[1] > actualDate[1] && endDateInt[2] > actualDate[2])) {
            inProgress = false;
        } else inProgress = true;
    }

    private int[] format(String string) {
        String[] date = string.split("/");
        int[] formattedDate = new int[date.length];
        for (int i = 0; i < formattedDate.length; i++) {
            formattedDate[i] = Integer.parseInt(date[i]);
        }
        return formattedDate;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getleague() {
        return league;
    }

    private void checkDates() {
        int[] startDateInt = format(startDate);
        int[] endDateInt = format(endDate);

        int startDateComparable = startDateInt[2] * 10000 + startDateInt[1] * 100 + startDateInt[0];
        int endDateComparable = endDateInt[2] * 10000 + endDateInt[1] * 100 + endDateInt[0];

        if (startDateComparable > endDateComparable) {
            String aux = startDate;
            startDate = endDate;
            endDate = aux;
        }      
    }
}
