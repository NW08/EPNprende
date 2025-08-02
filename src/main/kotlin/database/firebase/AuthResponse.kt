package main.kotlin.database.firebase

internal data class AuthResponse(
   internal val tokenID: String,
   internal val email: String,
   internal val localID: String
)