package main.java.utils;

public enum Strings {

   RESOURCE_404("Resource not found at: "),
   FXML_LOAD_ERROR("ScreenManager has not been initialized. Call init(root) first!"),
   LOGIN_EMAIL_FAILED("Email Incorrecto. Vuelve a intentarlo"),
   LOGIN_PASSWORD_FAILED("Contraseña Incorrecta"),
   LOGIN_EMAIL_EMPTY("Debes ingresar tu email"),
   LOGIN_PASSWORD_EMPTY("Por favor, ingresa tu contraseña"),
   EMPTY_TEXT(""),
   FXML_404("Error: FXML file not found at ");

   private final String text;

   Strings(String text) {
      this.text = text;
   }

   public String getText() {
      return text;
   }

}
