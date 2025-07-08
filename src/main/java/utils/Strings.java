package main.java.utils;

public enum Strings {

   RESOURCE_404 ("Resource not found at: "),
   FXML_404 ("Error: FXML file not found at ");

   private final String text;
   Strings(String text) { this.text = text; }
   public String getText() { return text; }

}
