package com.example.socialmediaapp.ui.view.viewmodel

import android.content.Context
import android.net.Uri
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socialmediaapp.data.Model.Post
import com.example.socialmediaapp.data.repo.UploadFragmentRepository

class UploadFragmentViewModel : ViewModel(){

    var repo=UploadFragmentRepository()
    var postlarListesi=MutableLiveData<List<Post>>()



    init {
        oku()
    }



    fun kaydet(imageData: Uri, comment:String, view: View){
        repo.kaydet(imageData, comment, view)
    }

    fun oku() {
        postlarListesi = repo.oku()
    }



}