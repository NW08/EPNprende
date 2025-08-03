package main.test.models.sing

import main.kotlin.models.sign.CheckNameFormat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckNameFormatTest {

    @Test
    fun nombreválido_con_mayúsculas_minúsculas() {
        val result = CheckNameFormat.checkNameFormat("Juan Pérez")
        assertTrue(result)
    }

    @Test
    fun nombreválido_con_acentos_Ñ() {
        val result = CheckNameFormat.checkNameFormat("María Ñusta")
        assertTrue(result)
    }

    @Test
    fun nombreinválido_con_números() {
        val result = CheckNameFormat.checkNameFormat("Carlos123")
        assertFalse(result)
    }

    @Test
    fun nombreinválido_con_símbolos_especiales() {
        val result = CheckNameFormat.checkNameFormat("Ana*Luisa")
        assertFalse(result)
    }

    @Test
    fun nombre_inválido_demasiado_corto() {
        val result = CheckNameFormat.checkNameFormat("A")
        assertFalse(result)
    }

    @Test
    fun nombreinválido_demasiado_largo() {
        val largo = "A".repeat(51)
        val result = CheckNameFormat.checkNameFormat(largo)
        assertFalse(result)
    }

    @Test
    fun nombreválido_con_espacios_al_inicio_fin() {
        val result = CheckNameFormat.checkNameFormat("  Luis Miguel  ")
        assertTrue(result)
    }

    @Test
    fun nombreinválido_con_solo_espacios() {
        val result = CheckNameFormat.checkNameFormat("     ")
        assertFalse(result)
    }
}
