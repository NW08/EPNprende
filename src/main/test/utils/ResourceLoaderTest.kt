package main.test.utils

import main.kotlin.utils.ResourceLoader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.net.URL

class ResourceLoaderTest {

    @Test
    fun getResource_retorna_URL_válida_si_el_recurso_existe() {
        // Asegúrate de que el archivo 'sample.txt' esté en src/main/resources/
        val url: URL = ResourceLoader.getResource("/main/test/firebase/sample.txt")
        Assertions.assertNotNull(url)
        Assertions.assertTrue(url.toString().contains("/main/test/firebase/sample.txt"))
    }

    @Test
    fun getResource_lanza_excepción_si_el_recurso_no_existe() {
        val path = "/recurso_inexistente.txt"

        val exception = Assertions.assertThrows(IllegalStateException::class.java) {
            ResourceLoader.getResource(path)
        }

        Assertions.assertTrue(exception.message!!.contains(path))
    }
}