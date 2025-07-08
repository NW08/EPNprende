package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TestController {

   private int i = 1;

   @FXML
   private Label lbl_text;

   @FXML
   void click() {
      lbl_text.setText("Hello World (" + i++ + ")");
   }

}