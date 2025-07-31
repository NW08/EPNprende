package main.kotlin.utils

import main.java.utils.Strings
import java.net.URL

internal object ResourceLoader {
   /**
    * Searches for a resource in the classpath and throws an error if it doesn't exist.
    *
    * @param path Path to the resource (must start with “/” if it is in the root of resources).
    * @return Non-null URL of the resource.
    * @throws IllegalStateException if the resource is not found.
    */

   internal fun getResource(path: String): URL {
      // 1. It tries to load it in the same way as Java: Class.getResource(path).
      val resource: URL? = ResourceLoader::class.java.getResource(path)

      // 2. If it is null, it prints in err exactly as before:
      if (resource == null) System.err.println(Strings.ERROR_FXML_NOT_FOUND.text + path)

      // 3. It is verified and, if it is still null, an IllegalStateException is thrown with the message:
      return checkNotNull(resource) { "${Strings.ERROR_RESOURCE_NOT_FOUND.text}$path" }
   }
}