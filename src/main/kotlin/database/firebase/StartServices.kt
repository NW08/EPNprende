package main.kotlin.database.firebase

import com.google.cloud.firestore.Firestore
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.cloud.FirestoreClient

internal object StartServices {
   val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
   val db: Firestore by lazy { FirestoreClient.getFirestore() }
}