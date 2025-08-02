package main.kotlin.models.login

import main.kotlin.database.firebase.StartServices.auth

internal object CheckDatabase {
   internal fun checkExistingUser(email: String): Boolean {
      try {
         auth.getUserByEmail(email)
         return false
      } catch (_: Exception) {
         return true
      }
   }
}