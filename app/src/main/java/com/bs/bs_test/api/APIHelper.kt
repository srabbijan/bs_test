package com.bs.bs_test.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


object APIHelper {

    var client = OkHttpClient.Builder()
        .connectTimeout(1000, TimeUnit.SECONDS)
        .readTimeout(1000, TimeUnit.SECONDS).build()

    val base_url = "https://api.github.com/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}