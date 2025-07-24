package main.java.utils;

public enum Paths {

   LOGIN_SCREEN("/main/resources/LoginScreen.fxml"),
   DASHBOARD_SCREEN("/main/resources/DashboardScreen.fxml"),
   LAUNCHER("/main/resources/RootScreen.fxml");

   private final String path;

   Paths(String path) {
      this.path = path;
   }

   public String getPath() {
      return path;
   }

}
