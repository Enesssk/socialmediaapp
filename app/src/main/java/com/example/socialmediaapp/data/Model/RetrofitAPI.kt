package com.example.socialmediaapp.data.Model


import com.example.socialmediaapp.ui.view.util.Util
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {


    @GET("/api/")
    suspend fun searchImage(

        @Query("q") searchQuery : String,
        @Query("key") apiKey : String= Util.apiKey) : Response<ImageResponse>





}