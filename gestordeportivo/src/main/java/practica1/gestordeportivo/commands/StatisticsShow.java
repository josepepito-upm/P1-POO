package practica1.gestordeportivo.commands;

import practica1.gestordeportivo.controllers.PlayerController;
import practica1.gestordeportivo.types.Errors;
import practica1.gestordeportivo.views.StatsView;

public class StatisticsShow extends PlayerCommands {

    private StatsView statsView = new StatsView();
    public StatisticsShow(PlayerController playerController) {
        super(playerController);
    }

    public Errors validate(String command) {
        super.validate(command);

        String[] parts = command.split(" ");

        if (parts.length != 2) {
            return Errors.FORMAT_ERROR;
        }
        if(parts[1] != "-csv" || parts[1] != "-json") {
            return Errors.FORMAT_ERROR;
        }
        return Errors.NULL;
    }

    public Errors execute(String command) {
        String[] parts = command.split(" ");

        if(validate(command).isNull()) {
            if(parts[1] == "-csv") {
                statsView.showStatisticsCSV();
            } else {
                statsView.showStatisticsJSON();
            }
            return Errors.NULL;
        } else return validate(command);       
    }
}
