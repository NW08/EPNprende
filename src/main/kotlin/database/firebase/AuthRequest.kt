package main.kotlin.database.firebase

internal data class AuthRequest(
   internal val email: String,
   internal val password: String,
   internal val returnSecureToken: Boolean = true
)