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
import main.kotlin.utils.CheckEmailFormat;

public class SignScreenController implements ViewLifecycle {

   private final BooleanProperty passwordVisible = new SimpleBooleanProperty(false);

   @FXML
   private Button btn_hide_password;

   @FXML
   private Button btn_view_password;

   @FXML
   private PasswordField confirm_field;

   @FXML
   private Label lbl_message_login;

   @FXML
   private Label lbl_message_password;

   @FXML
   private PasswordField pass_field;

   @FXML
   private StackPane signPane;

   @FXML
   private SVGPath svg_correct_mail;

   @FXML
   private SVGPath svg_incorrect_mail;

   @FXML
   private TextField txt_field_email;

   @FXML
   private TextField txt_field_name;

   @FXML
   private TextField txt_view_password;

   @Override
   public void onShow() {
      lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
      lbl_message_password.setText(Strings.EMPTY_TEXT.getText());
      txt_field_email.clear();
      txt_field_name.clear();
      pass_field.clear();
      confirm_field.clear();
      passwordVisible.set(false);
   }

   public void initialize() {
      txt_field_email.textProperty().addListener((_, _, _) -> {
         lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
         lbl_message_password.setText(Strings.EMPTY_TEXT.getText());
         updateEmailIcons();
      });

      pass_field.textProperty().addListener((_, _, _)
            -> lbl_message_password.setText(Strings.EMPTY_TEXT.getText()));

      // Vinculación bidireccional entre campos
      pass_field.textProperty().bindBidirectional(txt_view_password.textProperty());

      // Bind de visibilidad
      txt_view_password.visibleProperty().bind(passwordVisible);
      pass_field.visibleProperty().bind(passwordVisible.not());
      btn_hide_password.visibleProperty().bind(passwordVisible);
      btn_view_password.visibleProperty().bind(passwordVisible.not());
   }


   @FXML
   void changeToLoginAction() {
      Stage stage = (Stage) signPane.getScene().getWindow();
      RootController.showLogin(stage);
   }

   @FXML
   void signAction() {
      Stage stage = (Stage) signPane.getScene().getWindow();
      RootController.showDashboard(stage);
   }


   private boolean updateEmailIcons() {
      String email = txt_field_email.getText();

      if (email.isEmpty()) {
         svg_correct_mail.setVisible(false);
         svg_incorrect_mail.setVisible(false);
         return false;
      }

      boolean isRight = CheckEmailFormat.INSTANCE.checkEmailFormat$EPNprende(email);
      svg_correct_mail.setVisible(isRight);
      svg_incorrect_mail.setVisible(!isRight);
      return isRight;
   }

   private void catchData() {
      String email = updateEmailIcons() ? txt_field_email.getText() : null;
      String name = txt_field_name.getText();
   }

   @FXML
   void togglePasswordVisibility() {
      passwordVisible.set(!passwordVisible.get());
   }


   private boolean validateFields() {

      String password = "12345";

      if (txt_field_email.getText().isEmpty()) {
         lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
         lbl_message_login.setText(Strings.LOGIN_EMAIL_EMPTY.getText());
         lbl_message_password.setText(Strings.EMPTY_TEXT.getText());
         return false;
      } else if (pass_field.getText().isEmpty()) {
         lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
         lbl_message_login.setText(Strings.LOGIN_PASSWORD_EMPTY.getText());
         lbl_message_password.setText(Strings.LOGIN_PASSWORD_EMPTY.getText());
         return false;
      } else if (!updateEmailIcons()) {
         lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
         lbl_message_login.setText(Strings.LOGIN_EMAIL_FAILED.getText());
         return false;
      } else if (!pass_field.getText().equals(password)) {
         lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
         lbl_message_login.setText(Strings.LOGIN_PASSWORD_FAILED.getText());
         return false;
      } else return true;
   }

}
