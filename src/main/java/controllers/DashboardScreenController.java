package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DashboardScreenController {

   @FXML
   private StackPane dashboardPane;


   @FXML
   void changeCategoriesAction() {
      Stage stage = (Stage) dashboardPane.getScene().getWindow();
      RootController.showCategories(stage);
   }

   @FXML
   void changeOffersAction() {
      Stage stage = (Stage) dashboardPane.getScene().getWindow();
      RootController.showOffers(stage);
   }

   @FXML
   void changeFavoritesAction() {
      Stage stage = (Stage) dashboardPane.getScene().getWindow();
      RootController.showFavorites(stage);
   }


   @FXML
   void logoutAction() {
      Stage stage = (Stage) dashboardPane.getScene().getWindow();
      RootController.showLogin(stage);
   }

}
