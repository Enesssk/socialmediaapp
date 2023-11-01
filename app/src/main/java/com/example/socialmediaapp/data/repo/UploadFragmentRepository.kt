package com.example.socialmediaapp.data.repo

import android.content.Context
import android.net.Uri
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.socialmediaapp.data.Model.Post
import com.example.socialmediaapp.data.datastore.UploadFragmentDataSource

class UploadFragmentRepository {

    var uds=UploadFragmentDataSource()


    fun kaydet(imageData: Uri, comment:String, view: View){
        uds.kaydet(imageData, comment, view)
    }

    fun oku() : MutableLiveData<List<Post>> = uds.oku()


}