package main.kotlin.models.sign

internal object CheckEmailFormat {
   private val pattern: Regex = Regex("^[a-zA-Z][a-zA-Z0-9_.+-]{2,}@epn\\.edu\\.ec$")

   internal fun checkEmailFormat(email: String): Boolean {
      return email.matches(pattern)
   }
}