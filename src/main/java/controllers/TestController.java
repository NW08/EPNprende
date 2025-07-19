package main.java.controllers;

// TestController.java

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.java.model.TestModel;

public class TestController {

   @FXML
   private Label lbl_text;

   private TestModel model;

   @FXML
   public void initialize() {
      model = new TestModel();

      // Bind: label mostrará automáticamente "Hello World (n)"
      lbl_text.textProperty().bind(
            model.counterProperty()
                  .asString("Hello World (%d)")
      );
   }

   @FXML
   void click() {
      model.increment();
   }
}