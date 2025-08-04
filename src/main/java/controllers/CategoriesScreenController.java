package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CategoriesScreenController {

   @FXML
   private StackPane categoriesPane;

   @FXML
   void changeFavoritesAction() {
      Stage stage = (Stage) categoriesPane.getScene().getWindow();
      RootController.showFavorites(stage);
   }


   @FXML
   void changeOffersAction() {
      Stage stage = (Stage) categoriesPane.getScene().getWindow();
      RootController.showOffers(stage);
   }

   @FXML
   void changeProductsAction() {
      Stage stage = (Stage) categoriesPane.getScene().getWindow();
      RootController.showDashboard(stage);
   }

   @FXML
   void logoutAction() {
      Stage stage = (Stage) categoriesPane.getScene().getWindow();
      RootController.showLogin(stage);
   }

}