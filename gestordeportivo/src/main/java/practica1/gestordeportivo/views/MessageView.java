package practica1.gestordeportivo.views;

public class MessageView {
    public void showMessage(String command) {
        for (Message messages : Message.values()) {
            if(command.equals(messages.getCommand().getName()))
                messages.writeMessage(messages);
        }
    }
}