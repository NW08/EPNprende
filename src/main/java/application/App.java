package main.java.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.controllers.RootController;
import main.java.utils.Paths;
import main.kotlin.database.firebase.StartConnection;
import main.kotlin.database.postgres.InitConnection;
import main.kotlin.utils.ResourceLoader;

import java.io.IOException;

public class App extends Application {

   // Inicia la aplicación de JavaFX.
   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage stage) throws IOException {
      // Se inicia Firebase
      StartConnection.INSTANCE.init$EPNprende();

      // Creación de la interfaz base desde el FXML.
      FXMLLoader loader = new FXMLLoader(ResourceLoader.INSTANCE.getResource$EPNprende(Paths.LAUNCHER.getPath()));

      // Se carga la interfaz base previamente hecha en un layout raíz.
      StackPane root = loader.load();

      // Se crea la escena con el layout raíz que contiene la interfaz cargada.
      Scene scene = new Scene(root);

      // La escena es asignada a la ventana para mostrarse ya en pantalla.
      stage.setScene(scene);

      // Mediante el controlador se invoca a la pantalla de login para que esta se muestre en la escena.
      RootController.showLogin(stage);

      // Se establece el ícono de la ventana
      Image logo = new Image(ResourceLoader.INSTANCE.getResource$EPNprende(Paths.ICON_LOGO.getPath()).openStream());
      stage.getIcons().add(logo);

      stage.setOnCloseRequest(_ -> {
         InitConnection.INSTANCE.shutdown$EPNprende();
         Platform.exit();
         System.exit(0);
      });

      // Se invoca una función que centra la ventana a mostrarse.
      stage.centerOnScreen();

      // Finalmente, se muestra la ventana con la escena cargada en ella.
      stage.show();
   }

   @Override
   public void stop() {
      InitConnection.INSTANCE.shutdown$EPNprende();
   }
}