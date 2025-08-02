package main.kotlin.models.sign

import main.kotlin.database.firebase.StartServices.db

internal object CreateNewUser {

   /**
    * Crea o actualiza un usuario en Firestore.
    * Retorna true si fue exitoso, false en caso de error.
    */

   private fun addUserInFirestore(name: String, email: String, password: String): Boolean {
      return try {
         val data = mapOf<String, Any>(
            "name" to name,
            "email" to email,
            "password" to password
         )
         db.collection("users").document(email).set(data).get()
         true
      } catch (e: Exception) {
         e.printStackTrace()
         false
      }
   }


}