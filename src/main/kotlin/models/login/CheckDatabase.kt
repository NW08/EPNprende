package main.kotlin.models.login

import main.kotlin.database.firebase.StartServices.auth

internal object CheckDatabase {
   internal fun checkExistingUser(email: String): Boolean {
      try {
         auth.getUserByEmail(email)
         return true
      } catch (_: Exception) {
         return false
      }
   }
}