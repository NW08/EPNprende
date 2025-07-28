package main.kotlin.utils

internal object CheckPassword {
   internal fun checkPasswordLength(password: String): Boolean {
      return password.length >= 8 && password.length <= 16
   }

   internal fun checkPasswordFormat(password: String): Boolean {
      return (password.contains(Regex("[A-Z]"))
            && password.contains(Regex("[a-z]"))
            && password.contains(Regex("[0-9]"))
            && password.contains(Regex("[$&+,:;=?@#|'<>.^*()%!-]")))
   }

   internal fun checkPasswordSimilarity(password: String, confirmPassword: String): Boolean {
      return password == confirmPassword
   }
}