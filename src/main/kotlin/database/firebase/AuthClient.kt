package main.kotlin.database.firebase

import com.google.gson.Gson
import main.API
import okhttp3.OkHttpClient

internal object AuthClient {
   internal val API_KEY: String = API.SECRET.path
   internal val client: OkHttpClient = OkHttpClient()
   internal val gson: Gson = Gson()
}