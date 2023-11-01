package com.example.socialmediaapp.data.dependency

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.socialmediaapp.R
import com.example.socialmediaapp.data.Model.RetrofitAPI
import com.example.socialmediaapp.data.datastore.SearchDataStore
import com.example.socialmediaapp.data.repo.SearchRepository
import com.example.socialmediaapp.ui.view.util.Util
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleKotlin {


    @Singleton
    @Provides
    fun injectRetroifApi() : RetrofitAPI {
          return Retrofit.Builder().baseUrl(Util.Base_URL).addConverterFactory(
            GsonConverterFactory.create())
            .build().create(RetrofitAPI::class.java)
    }

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide
        .with(context).setDefaultRequestOptions(
            RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
        )

    @Provides
    @Singleton
    fun provideSearchDataSource(retrofitAPI: RetrofitAPI) : SearchDataStore{
        return SearchDataStore(retrofitAPI)

    }

    @Provides
    @Singleton
    fun provideSearchRepository(sds:SearchDataStore) : SearchRepository{
        return SearchRepository(sds)
    }



}