package main.test.models.sing

import main.kotlin.models.sign.CheckPassword
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckPasswordTest {

    @Test
    fun checkPasswordLength_válido_entre_8_16_caracteres() {
        assertTrue(CheckPassword.checkPasswordLength("Abc12345"))
        assertTrue(CheckPassword.checkPasswordLength("1234567890123456"))
    }

    @Test
    fun checkPasswordLength_inválido_menor_a_8_o_mayor_a_16() {
        assertFalse(CheckPassword.checkPasswordLength("12345"))
        assertFalse(CheckPassword.checkPasswordLength("A".repeat(17)))
    }

    @Test
    fun checkPasswordFormat_válido_mayúscula_minúscula_número_símbolo() {
        assertTrue(CheckPassword.checkPasswordFormat("Abc123$%"))
        assertTrue(CheckPassword.checkPasswordFormat("Xy9!pass"))
    }

    @Test
    fun checkPasswordFormat_inválido_sin_mayúscula() {
        assertFalse(CheckPassword.checkPasswordFormat("abc123$%"))
    }

    @Test
    fun checkPasswordFormat_inválido_sin_minúscula() {
        assertFalse(CheckPassword.checkPasswordFormat("ABC123$%"))
    }

    @Test
    fun checkPasswordFormat_inválido_sin_número() {
        assertFalse(CheckPassword.checkPasswordFormat("Abcdef$%"))
    }

    @Test
    fun checkPasswordFormat_inválido_sin_símbolo() {
        assertFalse(CheckPassword.checkPasswordFormat("Abc12345"))
    }

    @Test
    fun checkPasswordSimilarity_contraseñas_iguales() {
        assertTrue(CheckPassword.checkPasswordSimilarity("Pass123!", "Pass123!"))
    }

    @Test
    fun checkPasswordSimilarity_contraseñas_diferentes() {
        assertFalse(CheckPassword.checkPasswordSimilarity("Pass123!", "pass123!"))
    }
}
