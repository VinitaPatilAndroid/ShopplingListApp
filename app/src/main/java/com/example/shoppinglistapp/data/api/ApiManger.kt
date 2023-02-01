package com.example.shoppinglistapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManger {

    companion object {

        val BASE_URL = "http://staging.php-dev.in:8844/trainingapp/"

        fun create(): Api {

            val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val OkHttp = OkHttpClient.Builder().addInterceptor(logger).build()

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttp)
                .build()

            return retrofit.create(Api::class.java)
        }
    }
}