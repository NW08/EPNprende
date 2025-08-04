package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.utils.Paths;
import main.java.utils.ScreenManager;
import main.java.utils.Strings;

public class RootController {

   @FXML
   private StackPane root;

   // Métodos delegados
   public static void showLogin(Stage stage) {
      ScreenManager.show(Paths.LOGIN_SCREEN.getPath());
      stage.setTitle(Strings.LOGIN_TITLE.getText());
      stage.setWidth(700);
      stage.setHeight(700);
      stage.centerOnScreen();
   }

   static void showSign(Stage stage) {
      ScreenManager.show(Paths.SIGN_SCREEN.getPath());
      stage.setTitle(Strings.SIGN_TITLE.getText());
      stage.setWidth(700);
      stage.setHeight(700);
      stage.centerOnScreen();
   }

   public static void showDashboard(Stage stage) {
      ScreenManager.show(Paths.DASHBOARD_SCREEN.getPath());
      stage.setTitle(Strings.DASHBOARD_TITLE.getText());
      stage.setWidth(1300);
      stage.setHeight(800);
      stage.centerOnScreen();
   }

   static void showCategories(Stage stage) {
      ScreenManager.show(Paths.CATEGORIES_SCREEN.getPath());
      stage.setTitle(Strings.CATEGORIES_TITLE.getText());
      stage.setWidth(1300);
      stage.setHeight(800);
      stage.centerOnScreen();
   }

   static void showFavorites(Stage stage) {
      ScreenManager.show(Paths.FAVORITES_SCREEN.getPath());
      stage.setTitle(Strings.FAVORITES_TITLE.getText());
      stage.setWidth(1300);
      stage.setHeight(800);
      stage.centerOnScreen();
   }

   static void showOffers(Stage stage) {
      ScreenManager.show(Paths.OFFERS_SCREEN.getPath());
      stage.setTitle(Strings.OFFERS_TITLE.getText());
      stage.setWidth(1300);
      stage.setHeight(800);
      stage.centerOnScreen();
   }

   @FXML
   public void initialize() {
      ScreenManager.init(root);
   }
}