package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.utils.Paths;
import main.kotlin.ResourceLoader;

import java.io.IOException;

public class RootController {

   @FXML
   private StackPane root;
   private StackPane loginPane;

   @FXML
   public void initialize() {
      try {
         FXMLLoader loginLoader = new FXMLLoader(ResourceLoader.INSTANCE.getResource$EPNprende(Paths.LOGIN_SCREEN.getPath()));
         loginPane = loginLoader.load();

         // 1) Añade ambos al root StackPane
         root.getChildren().addAll(loginPane);


      } catch (IOException e) {
         System.out.println(e.getMessage());
      }
   }


   public void showLogin(Stage stage) {
      loginPane.setVisible(true);
      stage.setWidth(800);
      stage.setHeight(800);
   }
}