package main.java.utils;

/**
 * Mensajes de texto estáticos para la aplicación.
 */
public enum Strings {

   // ─── Errores de carga y configuración ─────────────────────────
   ERROR_RESOURCE_NOT_FOUND("Recurso no encontrado en: "),
   ERROR_KEY_FILE_NOT_FOUND("Archivo de claves no encontrado en: "),
   ERROR_FXML_NOT_FOUND("Error: archivo FXML no encontrado en: "),
   ERROR_SCREEN_MANAGER_NOT_INITIALIZED("ScreenManager no ha sido inicializado. Llama primero a init(root)!"),

   // ─── Validación de correo ────────────────────────────────────
   ERROR_EMAIL_EMPTY("Debes ingresar tu email"),
   ERROR_EMAIL_INCORRECT("Email incorrecto. Vuelve a intentarlo"),

   // ─── Validación de contraseña ────────────────────────────────
   ERROR_PASSWORD_EMPTY("Por favor, ingresa tu contraseña"),
   ERROR_PASSWORD_INCORRECT("Contraseña incorrecta"),
   ERROR_PASSWORD_LENGTH("La contraseña debe tener entre 8 y 16 caracteres"),
   ERROR_PASSWORD_FORMAT("Tu contraseña debe tener al menos una mayúscula, un número y un caracter especial"),
   ERROR_PASSWORD_MISMATCH("Las contraseñas no coinciden"),

   // ─── Validación de nombre ────────────────────────────────────
   ERROR_NAME_EMPTY("Debes ingresar tu nombre"),
   ERROR_NAME_INCORRECT("Verifica el nombre ingresado. Sólo puede contener letras y espacios"),

   // ─── Títulos de Ventanas ───────────────────────────────────────────────────
   LOGIN_TITLE("Login User"),
   SIGN_TITLE("Register New User"),
   DASHBOARD_TITLE("EPNprende Dashboard"),

   // ─── Otros ───────────────────────────────────────────────────
   EMPTY_TEXT("");

   private final String text;

   Strings(String text) {
      this.text = text;
   }

   /**
    * Obtiene el texto correspondiente al mensaje.
    */
   public String getText() {
      return text;
   }
}