package com.example.socialmediaapp.data.datastore

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.socialmediaapp.ui.view.view.FragmentLoginDirections
import com.example.socialmediaapp.ui.view.view.ProfileFragmentDirections
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginDataStore {

    private lateinit var auth:FirebaseAuth

    fun kayitOl(email : String,password: String,mContext: Context,view : View) {

        auth=Firebase.auth

        if(email.isNotEmpty() && password.isNotEmpty()){
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                Navigation.findNavController(view).navigate(FragmentLoginDirections.actionFragmentLoginToMainScreenFragment())

            }.addOnFailureListener {
                Toast.makeText(mContext,"Please enter email or password",Toast.LENGTH_LONG).show()
                Toast.makeText(mContext,"please enter a data",Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(mContext,"Please enter email or password",Toast.LENGTH_LONG).show()
        }
    }

    fun girişYap(email : String,password: String,mContext: Context,view : View){

        auth=Firebase.auth


        if(email.isNotEmpty() && password.isNotEmpty()){

            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {

                Navigation.findNavController(view).navigate(FragmentLoginDirections.actionFragmentLoginToMainScreenFragment())

            }.addOnFailureListener {
                Toast.makeText(mContext,"Please enter email or password",Toast.LENGTH_LONG).show()
                Toast.makeText(mContext,"Please enter",Toast.LENGTH_LONG).show()
                Toast.makeText(mContext,"Please enter a data",Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(mContext,"Please enter email or password",Toast.LENGTH_LONG).show()
        }
    }

    fun cikisYap(view:View){
        auth=Firebase.auth
        auth.signOut()
        Navigation.findNavController(view).navigate(ProfileFragmentDirections.actionProfileFragmentToFragmentLogin())
    }



}