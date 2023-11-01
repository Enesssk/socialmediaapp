package com.example.socialmediaapp.data.datastore

import android.content.Context
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.example.socialmediaapp.data.Model.Post
import com.example.socialmediaapp.ui.view.view.UploadFragmentDirections
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import java.util.UUID

class UploadFragmentDataSource {

    private lateinit var auth:FirebaseAuth
    private lateinit var storage:FirebaseStorage
    private lateinit var db:FirebaseFirestore
    var postlarListesi=MutableLiveData<List<Post>>()



    fun kaydet(imageData:Uri,comment:String,view: View){

        auth= Firebase.auth
        storage=Firebase.storage
        db=Firebase.firestore


        val uuid=UUID.randomUUID()
        val imageName="$uuid.jpg"

        val reference=storage.reference
        val imageReference=reference.child("images").child(imageName)

        if(imageData!=null){
            imageReference.putFile(imageData).addOnSuccessListener {
                imageReference.downloadUrl.addOnSuccessListener {
                    val downloadUrl=it.toString()

                    val postMap=HashMap<String, Any>()
                    postMap.put("downloadUrl",downloadUrl)
                    postMap.put("userEmail",auth.currentUser!!.email.toString())
                    postMap.put("comment",comment)
                    postMap.put("date",Timestamp.now())

                    db.collection("Posts").add(postMap).addOnSuccessListener {
                       Navigation.findNavController(view).navigate(UploadFragmentDirections.actionUploadFragmentToMainScreenFragment())

                    }

                }
            }
        }
    }


    fun oku() : MutableLiveData<List<Post>>{

        auth= Firebase.auth
        storage=Firebase.storage
        db=Firebase.firestore

        db.collection("Posts").addSnapshotListener { value, error ->

           if(value!=null){
               val liste=ArrayList<Post>()

               val document=value.documents
               for (d in document){
                   val comment=d.get("comment") as String
                   val email=d.get("userEmail") as String
                   val downloadUrl=d.get("downloadUrl") as String
                   val post=Post(email,comment,downloadUrl)
                   liste.add(post)
               }
               postlarListesi.value=liste
           }


        }


        return postlarListesi
    }



}