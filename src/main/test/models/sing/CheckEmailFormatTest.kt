package main.test.models.sing

import main.kotlin.models.sign.CheckEmailFormat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckEmailFormatTest {

    @Test
    fun emailválido_con_dominio_epn() {
        val email = "juan123@epn.edu.ec"
        val result = CheckEmailFormat.checkEmailFormat(email)
        assertTrue(result, "Debe aceptar emails válidos con dominio @epn.edu.ec")
    }

    @Test
    fun emailinválido_con_dominio_diferente() {
        val email = "juan123@gmail.com"
        val result = CheckEmailFormat.checkEmailFormat(email)
        assertFalse(result, "Debe rechazar emails que no sean de @epn.edu.ec")
    }

    @Test
    fun emailinválido_sin_empezarporletra() {
        val email = "1juan@epn.edu.ec"
        val result = CheckEmailFormat.checkEmailFormat(email)
        assertFalse(result, "Debe rechazar emails que no empiecen con letra")
    }

    @Test
    fun email_inválido_con_menos_de_3_caracteres_antes_del_arroba() {
        val email = "jo@epn.edu.ec"
        val result = CheckEmailFormat.checkEmailFormat(email)
        assertFalse(result, "Debe rechazar emails con menos de 3 caracteres antes del @")
    }

    @Test
    fun email_valido_con_puntos_y_guiones() {
        val email = "j.g-onzalez@epn.edu.ec"
        val result = CheckEmailFormat.checkEmailFormat(email)
        assertTrue(result, "Debe aceptar caracteres especiales válidos")
    }
}
