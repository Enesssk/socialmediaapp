package com.example.socialmediaapp.ui.view.viewmodel

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.socialmediaapp.data.repo.LoginRepository
import kotlin.math.log

class LoginViewModel : ViewModel() {

    var loginRepo=LoginRepository()


    fun kayitOl(email : String, password: String, mContext: Context, view : View){
        loginRepo.kayitOl(email,password, mContext, view)
    }

    fun girisYap(email : String, password: String, mContext: Context, view : View){
        loginRepo.girisYap(email, password, mContext, view)
    }

    fun cikisYap(view:View){
        loginRepo.cikisYap(view)
    }

}