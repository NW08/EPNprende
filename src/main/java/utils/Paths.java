package main.java.utils;

public enum Paths {

   LAUNCHER("/main/resources/LoginScreen.fxml");

   private final String path;

   Paths(String path) {
      this.path = path;
   }

   public String getPath() {
      return path;
   }

}
