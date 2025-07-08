package main.java.model;

import javafx.scene.control.Label;

public class TestModel {
    private int i = 0;
    private final Label label;

    public TestModel(Label lbl_text) {
        this.label = lbl_text;
        updateLabel();
    }

    public void updateLabel() { label.setText("Hello World (" + i++ + ")"); }
}
