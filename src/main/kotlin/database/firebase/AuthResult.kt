package main.kotlin.database.firebase

internal data class AuthResult(
   internal val success: Boolean,
   internal val user: AuthResponse?,
   internal val errorMessage: String? = null
)