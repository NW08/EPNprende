package main.kotlin.database.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import main.kotlin.utils.ResourceLoader

internal object StartConnection {
   internal fun init() {
      val options: FirebaseOptions = FirebaseOptions.builder()
         .setCredentials(GoogleCredentials.fromStream(ResourceLoader.loadServiceAccountStream()))
         .build()

      if (FirebaseApp.getApps().isEmpty()) FirebaseApp.initializeApp(options)
   }
}