package main.kotlin.database.firebase

internal class RegisterData(private val name: String, private val email: String, private val password: String) {

   override fun toString(): String {
      return "RegisterData(name='$name', email='$email', password='$password')"
   }
}