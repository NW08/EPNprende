package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.utils.Paths;
import main.java.utils.ScreenManager;

public class RootController {

   @FXML
   private StackPane root;

   // Métodos delegados
   public static void showLogin(Stage stage) {
      ScreenManager.show(Paths.LOGIN_SCREEN.getPath());
      stage.setWidth(700);
      stage.setHeight(700);
   }

   static void showSign(Stage stage) {
      ScreenManager.show(Paths.SIGN_SCREEN.getPath());
      stage.setWidth(700);
      stage.setHeight(700);
   }

   static void showDashboard(Stage stage) {
      ScreenManager.show(Paths.DASHBOARD_SCREEN.getPath());
      stage.setWidth(1280);
      stage.setHeight(780);
      stage.centerOnScreen();
   }

   @FXML
   public void initialize() {
      ScreenManager.init(root);
   }
}