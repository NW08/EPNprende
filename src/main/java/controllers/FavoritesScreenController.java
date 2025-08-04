package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FavoritesScreenController {

   @FXML
   private StackPane favoritesPane;


   @FXML
   void changeCategoriesAction() {
      Stage stage = (Stage) favoritesPane.getScene().getWindow();
      RootController.showCategories(stage);
   }

   @FXML
   void changeOffersAction() {
      Stage stage = (Stage) favoritesPane.getScene().getWindow();
      RootController.showOffers(stage);
   }

   @FXML
   void changeProductsAction() {
      Stage stage = (Stage) favoritesPane.getScene().getWindow();
      RootController.showDashboard(stage);
   }


   @FXML
   void logoutAction() {
      Stage stage = (Stage) favoritesPane.getScene().getWindow();
      RootController.showLogin(stage);
   }

}