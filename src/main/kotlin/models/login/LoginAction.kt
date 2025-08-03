package main.kotlin.models.login

import main.kotlin.database.firebase.AuthClient.API_KEY
import main.kotlin.database.firebase.AuthClient.client
import main.kotlin.database.firebase.AuthClient.gson
import main.kotlin.database.firebase.AuthError
import main.kotlin.database.firebase.AuthRequest
import main.kotlin.database.firebase.AuthResponse
import main.kotlin.database.firebase.AuthResult
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

internal object LoginAction {

   private val url: String = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=$API_KEY"

   internal fun login(email: String, password: String): AuthResult {
      val authRequest = AuthRequest(email, password)
      val json: String = gson.toJson(authRequest)

      val body: RequestBody = json.toRequestBody("application/json".toMediaType())

      val request: Request = Request.Builder()
         .url(url)
         .post(body)
         .build()

      client.newCall(request).execute().use { response ->
         val responseBody: String? = response.body?.string()
         return if (response.isSuccessful && responseBody != null) {
            val authResponse: AuthResponse = gson.fromJson(responseBody, AuthResponse::class.java)
            AuthResult(true, authResponse)
         } else {
            val error: AuthError = gson.fromJson(responseBody, AuthError::class.java)
            AuthResult(false, null, error.error.message)
         }
      }
   }
}