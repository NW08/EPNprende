package main.java.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import main.java.interfaces.ViewLifecycle;
import main.java.utils.Strings;
import main.kotlin.models.sign.CheckEmailFormat;
import main.kotlin.models.sign.CheckNameFormat;
import main.kotlin.models.sign.CheckPassword;
import main.kotlin.models.sign.CreateNewUser;

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


   // 1. Métodos Estáticos
   private static byte checkPassword(String password, String password_confirmation) {
      boolean isFormatPasswordCorrect = CheckPassword.INSTANCE.checkPasswordFormat$EPNprende(password);
      boolean isLengthPasswordCorrect = CheckPassword.INSTANCE.checkPasswordLength$EPNprende(password);
      boolean isSimilarPassword = CheckPassword.INSTANCE.checkPasswordSimilarity$EPNprende(password, password_confirmation);

      if (!isSimilarPassword) return 1;
      else if (!isFormatPasswordCorrect) return 2;
      else if (!isLengthPasswordCorrect) return 3;
      else return 0;
   }


   // 2. Ciclo de vida
   @FXML
   public void initialize() {
      txt_field_email.textProperty().addListener((_, _, _) -> {
         lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
         lbl_message_password.setText(Strings.EMPTY_TEXT.getText());
         checkEmail();
      });

      txt_field_name.textProperty().addListener((_, _, _) -> {
         lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
         lbl_message_password.setText(Strings.EMPTY_TEXT.getText());
      });

      pass_field.textProperty().addListener((_, _, _) -> {
         lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
         lbl_message_password.setText(Strings.EMPTY_TEXT.getText());
      });

      confirm_field.textProperty().addListener((_, _, _) -> {
         lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
         lbl_message_password.setText(Strings.EMPTY_TEXT.getText());
      });

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
      lbl_message_login.setText(Strings.EMPTY_TEXT.getText());
      lbl_message_password.setText(Strings.EMPTY_TEXT.getText());
      txt_field_email.clear();
      txt_field_name.clear();
      pass_field.clear();
      confirm_field.clear();
      passwordVisible.set(false);
   }


   // 3. Event Handlers
   @FXML
   void onKeyPressed(KeyEvent event) {
      if (event.getCode() == KeyCode.ENTER) signAction();
   }

   @FXML
   void togglePasswordVisibility() {
      passwordVisible.set(!passwordVisible.get());
   }

   @FXML
   void changeToLoginAction() {
      Stage stage = (Stage) signPane.getScene().getWindow();
      RootController.showLogin(stage);
   }

   @FXML
   void signAction() {
      if (!validateFields()) return;

      String name = txt_field_name.getText();
      String email = txt_field_email.getText();
      String password = txt_view_password.getText();

      CreateNewUser.INSTANCE.createNewUser$EPNprende(name, email, password);
      Stage stage = (Stage) signPane.getScene().getWindow();
      RootController.showDashboard(stage);
   }


   // 4. Validaciones
   private boolean validateFields() {
      String email = txt_field_email.getText();
      String name = txt_field_name.getText();
      String password = pass_field.getText();
      String confirmPassword = confirm_field.getText();

      byte passwordCheckResult = checkPassword(password, confirmPassword);

      if (email.isEmpty()) {
         lbl_message_login.setText(Strings.ERROR_EMAIL_EMPTY.getText());
         return false;
      }

      if (name.isEmpty()) {
         lbl_message_login.setText(Strings.ERROR_NAME_EMPTY.getText());
         return false;
      }

      if (password.isEmpty()) {
         lbl_message_password.setText(Strings.ERROR_PASSWORD_EMPTY.getText());
         return false;
      }

      if (confirmPassword.isEmpty()) {
         lbl_message_password.setText(Strings.ERROR_PASSWORD_MISMATCH.getText());
         return false;
      }

      if (!checkEmail()) {
         lbl_message_login.setText(Strings.ERROR_EMAIL_INCORRECT.getText());
         return false;
      }

      if (!checkNameField()) {
         lbl_message_login.setText(Strings.ERROR_NAME_INCORRECT.getText());
         return false;
      }

      return switch (passwordCheckResult) {
         case 1 -> {
            lbl_message_password.setText(Strings.ERROR_PASSWORD_MISMATCH.getText());
            yield false;
         }
         case 2 -> {
            lbl_message_password.setText(Strings.ERROR_PASSWORD_FORMAT.getText());
            yield false;
         }
         case 3 -> {
            lbl_message_password.setText(Strings.ERROR_PASSWORD_LENGTH.getText());
            yield false;
         }
         default -> true;
      };
   }

   private boolean checkEmail() {
      String email = txt_field_email.getText();

      if (email.isEmpty()) {
         svg_correct_mail.setVisible(false);
         svg_incorrect_mail.setVisible(false);
         return false;
      }

      boolean isEmailCorrect = CheckEmailFormat.INSTANCE.checkEmailFormat$EPNprende(email);
      svg_correct_mail.setVisible(isEmailCorrect);
      svg_incorrect_mail.setVisible(!isEmailCorrect);

      return isEmailCorrect;
   }

   private boolean checkNameField() {
      String name = txt_field_name.getText();
      return CheckNameFormat.INSTANCE.checkNameFormat$EPNprende(name);
   }
}