package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class OffersScreenController {

   @FXML
   private StackPane offersPane;

   @FXML
   void logoutAction() {
      Stage stage = (Stage) offersPane.getScene().getWindow();
      RootController.showLogin(stage);
   }

   @FXML
   void changeCategoriesAction() {
      Stage stage = (Stage) offersPane.getScene().getWindow();
      RootController.showCategories(stage);
   }

   @FXML
   void changeFavoritesAction() {
      Stage stage = (Stage) offersPane.getScene().getWindow();
      RootController.showFavorites(stage);
   }

   @FXML
   void changeProductsAction() {
      Stage stage = (Stage) offersPane.getScene().getWindow();
      RootController.showDashboard(stage);
   }

}
