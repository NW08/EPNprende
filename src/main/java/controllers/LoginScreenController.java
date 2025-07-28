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

   @Override
   public void onShow() {
      lbl_message.setText(Strings.EMPTY_TEXT.getText());
      txt_field_email.clear();
      pass_field.clear();
      passwordVisible.set(false);
   }

   public void initialize() {
      txt_field_email.textProperty().addListener((_, _, _) -> {
         lbl_message.setText(Strings.EMPTY_TEXT.getText());
         updateEmailIcons();
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

   @FXML
   void togglePasswordVisibility() {
      passwordVisible.set(!passwordVisible.get());
   }

   private boolean updateEmailIcons() {
      String email = txt_field_email.getText();

      if (email.isEmpty()) {
         svg_correct_email.setVisible(false);
         svg_incorrect_email.setVisible(false);
         return false;
      }

      boolean isRight = CheckEmailFormat.INSTANCE.checkEmailFormat$EPNprende(email);
      svg_correct_email.setVisible(isRight);
      svg_incorrect_email.setVisible(!isRight);
      return isRight;
   }

   private boolean validateFields() {

      String password = "12345";

      if (txt_field_email.getText().isEmpty()) {
         lbl_message.setText(Strings.EMPTY_TEXT.getText());
         lbl_message.setText(Strings.LOGIN_EMAIL_EMPTY.getText());
         return false;
      } else if (pass_field.getText().isEmpty()) {
         lbl_message.setText(Strings.EMPTY_TEXT.getText());
         lbl_message.setText(Strings.LOGIN_PASSWORD_EMPTY.getText());
         return false;
      } else if (!updateEmailIcons()) {
         lbl_message.setText(Strings.EMPTY_TEXT.getText());
         lbl_message.setText(Strings.LOGIN_EMAIL_FAILED.getText());
         return false;
      } else if (!pass_field.getText().equals(password)) {
         lbl_message.setText(Strings.EMPTY_TEXT.getText());
         lbl_message.setText(Strings.LOGIN_PASSWORD_FAILED.getText());
         return false;
      } else return true;
   }
}