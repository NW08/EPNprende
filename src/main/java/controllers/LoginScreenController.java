package main.java.controllers;

import javafx.animation.PauseTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.java.interfaces.ViewLifecycle;
import main.java.utils.Strings;
import main.kotlin.database.firebase.AuthResult;
import main.kotlin.models.login.CheckDatabase;
import main.kotlin.models.login.LoginAction;

public class LoginScreenController implements ViewLifecycle {

   // Aquí almacenamos el último estado de la verificación:
   private final BooleanProperty emailVerified = new SimpleBooleanProperty(false);

   private final BooleanProperty passwordVisible = new SimpleBooleanProperty(false);

   private PauseTransition pause;

   @FXML
   private Button btn_hide_password;

   @FXML
   private Button btn_view_password;

   @FXML
   private Label lbl_message;

   @FXML
   private StackPane loginPane;

   @FXML
   private PasswordField pass_field;

   @FXML
   private SVGPath svg_correct_email;

   @FXML
   private SVGPath svg_incorrect_email;

   @FXML
   private TextField txt_field_email;

   @FXML
   private TextField txt_view_password;


   // 1. Ciclo de Vida
   @FXML
   public void initialize() {
      pause = new PauseTransition(Duration.millis(300));

      txt_field_email.textProperty().addListener((_, _, _) -> {
         lbl_message.setText(Strings.EMPTY_TEXT.getText());
         pause.playFromStart();
      });

      pass_field.textProperty().addListener((_, _, _)
            -> lbl_message.setText(Strings.EMPTY_TEXT.getText()));


      // Vinculación bidireccional entre campos
      pass_field.textProperty().bindBidirectional(txt_view_password.textProperty());

      // Bind de visibilidad
      txt_view_password.visibleProperty().bind(passwordVisible);
      pass_field.visibleProperty().bind(passwordVisible.not());
      btn_hide_password.visibleProperty().bind(passwordVisible);
      btn_view_password.visibleProperty().bind(passwordVisible.not());

      pause.setOnFinished(_ -> verifyEmailAsync());
   }

   @Override
   public void onShow() {
      lbl_message.setText(Strings.EMPTY_TEXT.getText());
      txt_field_email.clear();
      pass_field.clear();
      passwordVisible.set(false);
   }


   // 2. Events -- Handlers
   @FXML
   void onKeyPressed(KeyEvent event) {
      if (event.getCode() == KeyCode.ENTER) loginAction();
   }

   @FXML
   void togglePasswordVisibility() {
      passwordVisible.set(!passwordVisible.get());
   }

   @FXML
   void changeToSignAction() {
      Stage stage = (Stage) loginPane.getScene().getWindow();
      RootController.showSign(stage);
   }

   @FXML
   void loginAction() {
      if (!validateFields()) return;
      Stage stage = (Stage) loginPane.getScene().getWindow();
      RootController.showDashboard(stage);
   }


   // 3. Validaciones
   private boolean validateFields() {
      String email = txt_field_email.getText();
      String password = pass_field.getText();

      if (email.isEmpty()) {
         lbl_message.setText(Strings.ERROR_EMAIL_EMPTY.getText());
         return false;
      }

      if (password.isEmpty()) {
         lbl_message.setText(Strings.ERROR_PASSWORD_EMPTY.getText());
         return false;
      }

      if (!emailVerified.get()) {
         lbl_message.setText(Strings.ERROR_EMAIL_INCORRECT.getText());
         return false;
      }

      if (!getVerifiedCredential()) {
         lbl_message.setText(Strings.ERROR_PASSWORD_INCORRECT.getText());
         return false;
      }

      return true;
   }

   private void verifyEmailAsync() {
      String email = txt_field_email.getText();
      if (email.isEmpty()) {
         emailVerified.set(false);
         svg_correct_email.setVisible(false);
         svg_incorrect_email.setVisible(false);
         return;
      }

      Task<Boolean> task = new Task<>() {
         @Override
         protected Boolean call() {
            return CheckDatabase.INSTANCE.checkExistingUser$EPNprende(email);
         }
      };

      task.setOnSucceeded(_ -> {
         boolean exists = task.getValue();
         emailVerified.set(exists);
         svg_correct_email.setVisible(exists);
         svg_incorrect_email.setVisible(!exists);
      });

      task.setOnFailed(_ -> {
         emailVerified.set(false);
         svg_correct_email.setVisible(false);
         svg_incorrect_email.setVisible(true);
      });

      // lanza el task en un hilo aparte:
      Thread th = new Thread(task);
      th.setDaemon(true);
      th.start();
   }

   private boolean getVerifiedCredential() {
      String email = txt_field_email.getText();
      String password = pass_field.getText();

      AuthResult result = LoginAction.INSTANCE.login$EPNprende(email, password);
      return result.getSuccess$EPNprende();
   }
}