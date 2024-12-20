package practica1.gestordeportivo.views;
import practica1.gestordeportivo.models.User;


public class UserView extends View {

    private User user;

    public UserView(User user) {
        this.user = user;
    }

    public void view() {
        System.out.print(user.getUsername() != null ? user.getUsername() : "Guest" + "#" + user.getRole() != null ? user.getRole() : "NO_ROLE"); 
    } 
}
