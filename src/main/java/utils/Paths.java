package main.java.utils;

/**
 * Rutas a los archivos FXML de la aplicación.
 */
public enum Paths {

   // ─── Pantalla principal ──────────────────────────────────────
   LAUNCHER("/main/resources/views/RootScreen.fxml"),

   // ─── Autenticación ──────────────────────────────────────────
   LOGIN_SCREEN("/main/resources/views/LoginScreen.fxml"),
   SIGN_SCREEN("/main/resources/views/SignScreen.fxml"),

   // ─── Interfaz de usuario ────────────────────────────────────
   DASHBOARD_SCREEN("/main/resources/views/DashboardScreen.fxml"),

   // ─── Firebase ──────────────────────────────────────
   KEY_FILE("main/serviceAccountKey.json"),

   // ─── Icons ──────────────────────────────────────
   ICON_LOGO("/main/resources/images/logo.jpg");

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