package com.example.socialmediaapp.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialmediaapp.data.Model.Post
import com.example.socialmediaapp.databinding.MainrecyclerviewBinding

class MainAdapter(var mContext: Context, var postList:List<Post>) : RecyclerView.Adapter<MainAdapter.TasarimTutucu>() {


    inner class TasarimTutucu(var binding:MainrecyclerviewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasarimTutucu {
        var binding=MainrecyclerviewBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return TasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: TasarimTutucu, position: Int) {

        val post=postList.get(position)
        val t=holder.binding

        t.comment.text=post.comment
        Glide.with(mContext).load(post.downloadUrl).into(t.imageView20)

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}