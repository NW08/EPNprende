package main.kotlin.models.login

internal object CheckDatabase {
   internal fun checkEmailInDataBase(email: String): Boolean {
      return email == "eduardo.ganchala@epn.edu.ec"
   }

   internal fun checkPasswordInDataBase(password: String): Boolean {
      return password == "Hola@12345"
   }
}