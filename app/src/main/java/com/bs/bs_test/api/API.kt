package com.bs.bs_test.api

import com.bs.bs_test.model.DataModels
import com.bs.bs_test.model.SingleOwner
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @GET("search/repositories")
    suspend fun getApiCall(@Query("q") q:String,@Query("sort")sort:String) : DataModels

    @GET("users/{username}")
    suspend fun getOwnerInfo(@Path("username") username:String): SingleOwner

}