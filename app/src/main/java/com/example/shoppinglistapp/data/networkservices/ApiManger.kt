package com.example.shoppinglistapp.data.networkservices

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/*
class ApiManger {

    companion object {

        val BASE_URL = "http://staging.php-dev.in:8844/trainingapp/"

        fun createRetrofitInstance(): NetworkApi {

            val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val OkHttp = OkHttpClient.Builder().addInterceptor(logger).build()

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttp)
                .build()

            return retrofit.create(NetworkApi::class.java)
        }
    }
}*/
