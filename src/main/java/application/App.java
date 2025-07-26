package main.java.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.controllers.RootController;
import main.java.utils.Paths;
import main.kotlin.ResourceLoader;

import java.io.IOException;

public class App extends Application {

   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage stage) throws IOException {
      
      FXMLLoader loader = new FXMLLoader(ResourceLoader.INSTANCE.getResource$EPNprende(Paths.LAUNCHER.getPath()));
      StackPane root = loader.load();
      RootController rootController = loader.getController();

      Scene scene = new Scene(root);
      stage.setScene(scene);

      rootController.showLogin(stage);

      stage.centerOnScreen();
      stage.show();
   }

}