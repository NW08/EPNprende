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
   private StackPane root; // Contenedor principal de la interfaz.
   private StackPane loginPane; // Panel de login que se mostrará.

   @FXML
   public void initialize() {
      try {
         // Carga la interfaz de la pantalla de login desde el archivo FXML
         FXMLLoader loginLoader = new FXMLLoader(ResourceLoader.INSTANCE.getResource$EPNprende(Paths.LOGIN_SCREEN.getPath()));

         // Carga el layout de la pantalla de login
         loginPane = loginLoader.load();

         // Aquí se añade el panel de login al contenedor principal
         root.getChildren().addAll(loginPane);

      } catch (IOException e) {
         // Manejo de excepciones en caso de error al cargar el FXML
         System.out.println(e.getMessage());
      }
   }

   // Method para mostrar la pantalla de login
   public void showLogin(Stage stage) {
      loginPane.setVisible(true); // Hace visible el panel de login
      stage.setWidth(800); // Establece el ancho de la ventana
      stage.setHeight(800); // Establece la altura de la ventana
   }
}