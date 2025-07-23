package main.java.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.utils.Paths;
import main.kotlin.ResourceLoader;

import java.io.IOException;

public class App extends Application {

   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage stage) throws IOException {

      // Cargar el recurso FXML
      var resource = ResourceLoader.INSTANCE.getResource$EPNprende(Paths.LAUNCHER.getPath());
      StackPane root = FXMLLoader.load(resource);

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
