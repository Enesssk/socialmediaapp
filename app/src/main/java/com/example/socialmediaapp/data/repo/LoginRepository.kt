package com.example.socialmediaapp.data.repo

import android.content.Context
import android.view.View
import com.example.socialmediaapp.data.datastore.LoginDataStore

class LoginRepository {

    var lds = LoginDataStore()

    fun kayitOl(email : String, password: String, mContext: Context, view : View) {
        lds.kayitOl(email,password,mContext,view)
    }

    fun girisYap(email : String, password: String, mContext: Context, view : View) {
        lds.girişYap(email, password, mContext, view)
    }

    fun cikisYap(view:View){
        lds.cikisYap(view)
    }


}