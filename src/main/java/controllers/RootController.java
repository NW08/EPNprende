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
   private StackPane signPane; // Panel de registro que se mostrará.
   private StackPane dashboardPane; // Panel principal después de validar credenciales.

   @FXML
   public void initialize() {
      try {
         // Carga la interfaz de las pantallas desde los archivos FXML
         FXMLLoader loginLoader = new FXMLLoader(ResourceLoader.INSTANCE.getResource$EPNprende(Paths.LOGIN_SCREEN.getPath()));
         FXMLLoader signLoader = new FXMLLoader(ResourceLoader.INSTANCE.getResource$EPNprende(Paths.SIGN_SCREEN.getPath()));
         FXMLLoader dashboardLoader = new FXMLLoader(ResourceLoader.INSTANCE.getResource$EPNprende(Paths.DASHBOARD_SCREEN.getPath()));

         // Carga el layout de las pantallas
         loginPane = loginLoader.load();
         signPane = signLoader.load();
         dashboardPane = dashboardLoader.load();

         // Aquí se añaden los paneles al contenedor principal
         root.getChildren().addAll(dashboardPane, signPane, loginPane);

      } catch (IOException e) {
         // Manejo de excepciones en caso de error al cargar el FXML
         System.out.println(e.getMessage());
      }
   }

   // Method para mostrar la pantalla de login
   public void showLogin(Stage stage) {
      loginPane.setVisible(true); // Hace visible el panel de login
      signPane.setVisible(false);
      stage.setWidth(800); // Establece el ancho de la ventana
      stage.setHeight(800); // Establece la altura de la ventana
   }

   // Method para mostrar la pantalla de registro
   public void showSign(Stage stage) {
      loginPane.setVisible(false);
      signPane.setVisible(true);
      stage.setWidth(800);
      stage.setHeight(800);
   }

   // Method para mostrar la pantalla del dashboard
   public void showDashboard(Stage stage) {
      loginPane.setVisible(false);
      signPane.setVisible(false);
      dashboardPane.setVisible(true);
      stage.setWidth(1643);
      stage.setHeight(924);
   }
}