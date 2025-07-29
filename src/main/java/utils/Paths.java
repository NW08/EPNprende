package main.java.utils;

/**
 * Rutas a los archivos FXML de la aplicación.
 */
public enum Paths {

   // ─── Pantalla principal ──────────────────────────────────────
   LAUNCHER("/main/resources/RootScreen.fxml"),

   // ─── Autenticación ──────────────────────────────────────────
   LOGIN_SCREEN("/main/resources/LoginScreen.fxml"),
   SIGN_SCREEN("/main/resources/SignScreen.fxml"),

   // ─── Interfaz de usuario ────────────────────────────────────
   DASHBOARD_SCREEN("/main/resources/DashboardScreen.fxml");

   private final String path;

   Paths(String path) {
      this.path = path;
   }

   /**
    * Obtiene la ruta FXML asociada.
    */
   public String getPath() {
      return path;
   }
}