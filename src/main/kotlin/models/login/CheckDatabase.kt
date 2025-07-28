package main.kotlin.models.login

internal object CheckDatabase {

   internal fun checkEmailInDataBase(email: String): Boolean {
      return email == "josue.ortiz02@epn.edu.ec"
   }

   internal fun checkPasswordInDataBase(password: String): Boolean {
      return password == "12345"
   }
}