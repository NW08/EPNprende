package main.kotlin.utils

internal object CheckEmailFormat {
   internal fun checkEmailFormat(email: String): Boolean {
      val pattern = Regex("^[A-Za-z0-9+_.-]+@epn\\.edu\\.ec$")
      return email.matches(pattern)
   }
}