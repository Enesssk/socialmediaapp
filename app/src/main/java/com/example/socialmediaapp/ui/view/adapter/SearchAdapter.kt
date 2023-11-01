package com.example.socialmediaapp.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.socialmediaapp.data.Model.ImageResponse
import com.example.socialmediaapp.data.Model.Post
import com.example.socialmediaapp.databinding.SearchrecyclerviewBinding
import javax.inject.Inject

class SearchAdapter @Inject constructor(val glide:RequestManager) : RecyclerView.Adapter<SearchAdapter.CardTasarimTutucu>(){

    var list : List<String> = listOf()

    inner class CardTasarimTutucu(var binding: SearchrecyclerviewBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
       var binding=SearchrecyclerviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardTasarimTutucu(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        

        glide.load(list[position]).into(holder.binding.imageViewAPI)



    }





    override fun getItemCount(): Int {
        return list.size
    }
}