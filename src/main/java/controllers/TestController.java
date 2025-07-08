package main.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.java.model.TestModel;

public class TestController {

   TestModel model;

   @FXML
   private Label lbl_text;

   public void initialize() { model = new TestModel(lbl_text); }

   @FXML
   void click() { model.updateLabel(); }

}