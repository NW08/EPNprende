package main.java.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.SVGPath;

public class SignScreenController {

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

   @FXML
   void changeToLoginAction(ActionEvent event) {

   }

   @FXML
   void hidePassword(ActionEvent event) {

   }

   @FXML
   void signAction(ActionEvent event) {

   }

   @FXML
   void viewPassword(ActionEvent event) {

   }

}
