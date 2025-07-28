package main.kotlin.models.sign

internal object CheckNameFormat {

   internal fun checkNameFormat(name: String): Boolean {
      val trimmed = name.trim()
      if (trimmed.length < 2 || trimmed.length > 50) return false

      // Regex: letras (mayúsculas, minúsculas), espacios y caracteres acentuados
      val pattern = Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")
      return pattern.matches(trimmed)
   }
}
