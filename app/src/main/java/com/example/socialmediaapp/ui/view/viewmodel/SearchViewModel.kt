package com.example.socialmediaapp.ui.view.viewmodel

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.socialmediaapp.data.Model.ImageResponse
import com.example.socialmediaapp.data.repo.SearchRepository
import com.example.socialmediaapp.ui.view.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(var searchRepo : SearchRepository): ViewModel() {



    private val images = MutableLiveData<Resource<ImageResponse>>()
    val imageList : LiveData<Resource<ImageResponse>>
        get() = images





     fun searchImage(searchString: String){
        if (searchString.isEmpty()){
            return
        }
        images.value= Resource.loading(null)
        viewModelScope.launch {
            val response=searchRepo.searchImage(searchString)
            images.value=response
        }
    }


}