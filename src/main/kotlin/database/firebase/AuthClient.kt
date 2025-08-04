package main.kotlin.database.firebase

import com.google.gson.Gson
import main.SECRETS
import okhttp3.OkHttpClient

internal object AuthClient {
   internal val SECRETS_KEY: String = SECRETS.SECRET.path
   internal val client: OkHttpClient = OkHttpClient()
   internal val gson: Gson = Gson()
}