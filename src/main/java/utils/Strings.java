package main.java.utils;

public enum Strings {

   MISSING_RESOURCE("Resource not found at: "),
   SCREEN_MANAGER_INIT_ERROR("ScreenManager has not been initialized. Call init(root) first!"),
   INCORRECT_EMAIL("Email Incorrecto. Vuelve a intentarlo"),
   INCORRECT_PASSWORD("Contraseña Incorrecta"),
   EMAIL_EMPTY("Debes ingresar tu email"),
   PASSWORD_EMPTY("Por favor, ingresa tu contraseña"),
   CONFIRM_PASSWORD_EMPTY("Confirma tu contraseña"),
   NAME_EMPTY("Debes ingresar tu nombre"),
   INCORRECT_NAME("Verifica el nombre ingresado. Solo puede contener letras y espacios"),
   PASSWORD_NOT_MATCH("Las contraseñas no coinciden"),
   INCORRECT_PASSWORD_FORMAT("Tu contraseña debe tener al menos una mayúscula, un número y un caracter especial"),
   INCORRECT_PASSWORD_LENGTH("La contraseña debe tener entre 8 y 16 caracteres"),
   EMPTY_TEXT(""),
   MISSING_FXML("Error: FXML file not found at ");

   private final String text;

   Strings(String text) {
      this.text = text;
   }

   public String getText() {
      return text;
   }

}
