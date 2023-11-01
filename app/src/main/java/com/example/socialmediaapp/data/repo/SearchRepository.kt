package com.example.socialmediaapp.data.repo

import com.example.socialmediaapp.data.Model.ImageResponse
import com.example.socialmediaapp.data.datastore.SearchDataStore
import com.example.socialmediaapp.ui.view.util.Resource

class SearchRepository(var sds:SearchDataStore) {





    suspend fun searchImage(searchString: String) : Resource<ImageResponse> {
        return sds.searchImage(searchString)
    }

}