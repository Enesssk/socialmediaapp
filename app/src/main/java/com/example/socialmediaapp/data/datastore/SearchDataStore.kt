package com.example.socialmediaapp.data.datastore

import android.content.Context
import android.widget.Toast
import com.example.socialmediaapp.data.Model.ImageResponse
import com.example.socialmediaapp.data.Model.RetrofitAPI
import com.example.socialmediaapp.ui.view.util.Resource
import com.example.socialmediaapp.ui.view.util.Util.Base_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchDataStore (val retrofitAPI: RetrofitAPI) {





     suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return  try {

            val response=retrofitAPI.searchImage(imageString)
            if(response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Errorrr!",null)
            }else{
                Resource.error("Errorr!",null)
            }
        }catch (e : java.lang.Exception){
            Resource.error("Error!",null)
        }
    }



}