package main.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.utils.Paths;

import java.io.IOException;
import java.util.Objects;

public class RootController {

   @FXML
   private StackPane rootStack;

   private Parent loginPane;
   private Parent dashboardPane;

   @FXML
   public void initialize() {
      try {

         // Cargar FXML del login
         loginPane = FXMLLoader.load(Objects.requireNonNull(
               getClass().getResource(Paths.LOGIN_SCREEN.getPath()))
         );

         // Cargar FXML del dashboard (cuando lo tengas listo)
         dashboardPane = FXMLLoader.load(Objects.requireNonNull(
               getClass().getResource(Paths.DASHBOARD_SCREEN.getPath()))
         );

         // Agregar ambos al stack (login arriba inicialmente)
         rootStack.getChildren().addAll(dashboardPane, loginPane);

         // Mostrar solo login al inicio
         dashboardPane.setVisible(false);
         loginPane.setVisible(true);

      } catch (IOException e) {
         System.out.println(e.getMessage());
      }
   }

   /**
    * Cambiar a login
    */
   public void showLogin(Stage stage) {
      loginPane.setVisible(true);
      dashboardPane.setVisible(false);
      stage.setWidth(800);
      stage.setHeight(800);
   }

   /**
    * Cambiar a dashboard
    */
   public void showDashboard(Stage stage) {
      loginPane.setVisible(false);
      dashboardPane.setVisible(true);
      stage.setWidth(1643);
      stage.setHeight(924);
   }
}
