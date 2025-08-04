package main.kotlin.models.sign

import main.java.utils.Strings
import main.kotlin.database.firebase.AuthClient.SECRETS_KEY
import main.kotlin.database.firebase.AuthClient.client
import main.kotlin.database.firebase.AuthClient.gson
import main.kotlin.database.firebase.StartServices.db
import main.kotlin.database.postgres.InitConnection
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

internal object CreateNewUser {

   private val url: String = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=$SECRETS_KEY"

   private var id: Int? = null

   /**
    * Registra un usuario en Firebase Auth usando email/password.
    * @return true si la respuesta HTTP fue 200 – 299, false en cualquier otro caso o excepción.
    */
   internal fun createNewUser(name: String, email: String, password: String): Boolean {
      // 1. Prepara el payload
      val payload = mapOf(
         "email" to email,
         "password" to password,
         "displayName" to name,           // si quieres guardar el nombre en el profile
         "returnSecureToken" to true
      )

      // 2. Serializa y construye el body
      val json = gson.toJson(payload)
      val body = json.toRequestBody("application/json".toMediaType())

      // 3. Construye la petición
      val request = Request.Builder()
         .url(url)
         .post(body)
         .build()

      // 4. Ejecuta y devuelve true si fue 2xx
      return try {
         client.newCall(request)
            .execute()
            .use { response -> response.isSuccessful }

         addUserInFirestore(name, email, password)
      } catch (e: Exception) {
         e.printStackTrace()
         false
      }
   }

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
         val userId = addUserInPostgres(email)
         if (userId != null) {
            this.id = userId
            true
         } else false
      } catch (e: Exception) {
         e.printStackTrace()
         false
      }
   }

   private fun addUserInPostgres(id: String): Int? {
      InitConnection.connect().use { conn ->
         conn.prepareStatement(Strings.UPDATE_NEW_USER_QUERY.text).use { stmt ->
            stmt.setBytes(1, id.toByteArray())
            stmt.executeQuery().use { rs ->
               return if (rs.next()) rs.getInt("user_id") else null
            }
         }
      }
   }

   internal fun getUserID(): Int? {
      return this.id
   }
}