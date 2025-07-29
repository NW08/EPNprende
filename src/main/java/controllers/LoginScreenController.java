package main.java.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import main.java.interfaces.ViewLifecycle;
import main.java.utils.Strings;
import main.kotlin.models.login.CheckDatabase;

public class LoginScreenController implements ViewLifecycle {

   private final BooleanProperty passwordVisible = new SimpleBooleanProperty(false);

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
      txt_field_email.textProperty().addListener((_, _, _) -> {
         lbl_message.setText(Strings.EMPTY_TEXT.getText());
         getVerifiedEmail();
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
   void onKeyPressed(javafx.scene.input.KeyEvent event) {
      if (event.getCode() == javafx.scene.input.KeyCode.ENTER) loginAction();
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

      if (!getVerifiedEmail()) {
         lbl_message.setText(Strings.ERROR_EMAIL_INCORRECT.getText());
         return false;
      }

      if (!getVerifiedCredential()) {
         lbl_message.setText(Strings.ERROR_PASSWORD_INCORRECT.getText());
         return false;
      }
      return true;
   }

   private boolean getVerifiedEmail() {
      String email = txt_field_email.getText();

      if (email.isEmpty()) {
         svg_correct_email.setVisible(false);
         svg_incorrect_email.setVisible(false);
         return false;
      }

      boolean isEmailVerified = CheckDatabase.INSTANCE.checkEmailInDataBase$EPNprende(email);
      svg_correct_email.setVisible(isEmailVerified);
      svg_incorrect_email.setVisible(!isEmailVerified);

      return isEmailVerified;
   }

   private boolean getVerifiedCredential() {
      String password = pass_field.getText();
      return CheckDatabase.INSTANCE.checkPasswordInDataBase$EPNprende(password);
   }
}