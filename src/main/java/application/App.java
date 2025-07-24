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

      // Crear el loader
      FXMLLoader loader = new FXMLLoader(ResourceLoader.INSTANCE.getResource$EPNprende(Paths.LAUNCHER.getPath()));

      // Cargar el root
      StackPane root = loader.load();

      // Obtener el controlador
      RootController rootController = loader.getController();
      root.setUserData(rootController);

      // Crear la escena
      Scene scene = new Scene(root);

      // Establecer la escena en el escenario
      stage.centerOnScreen();
      stage.setWidth(800);
      stage.setHeight(800);
      stage.setScene(scene);
      stage.show();
   }
}