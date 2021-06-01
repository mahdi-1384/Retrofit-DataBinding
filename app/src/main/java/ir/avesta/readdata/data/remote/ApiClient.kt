package ir.avesta.readdata.data.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient() {

    companion object {

        private var retrofit: Retrofit? = null
        private val baseUrl = "https://drive.google.com/";

        private val gson = GsonBuilder()
                .setLenient()
                .create()

        fun getDatabase(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .baseUrl(baseUrl)
                        .build()
            }

            return retrofit
        }

    }

}