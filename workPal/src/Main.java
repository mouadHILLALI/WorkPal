import configuration.DatabaseConnection;
import controller.MenuController;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.mainMenu();
    }
}