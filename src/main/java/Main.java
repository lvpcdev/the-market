import controller.MenuController;
import controller.UserController;
import model.entities.User;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        MenuController menuController = new MenuController();
        boolean exit = false;

        User user = null;

        do {
            try {
                user = userController.start();
                if (user != null) {
                    menuController.start(user);
                }

                if (userController.option() == 3) {
                    exit = true;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());

            }
        } while (exit == false);
    }
}
