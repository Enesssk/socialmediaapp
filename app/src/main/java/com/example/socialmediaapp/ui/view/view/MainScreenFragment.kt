package com.example.socialmediaapp.ui.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialmediaapp.data.Model.Post
import com.example.socialmediaapp.databinding.FragmentEntranceBinding
import com.example.socialmediaapp.databinding.FragmentMainScreenBinding
import com.example.socialmediaapp.ui.view.adapter.MainAdapter
import com.example.socialmediaapp.ui.view.viewmodel.UploadFragmentViewModel

class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private lateinit var viewModel: UploadFragmentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:UploadFragmentViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMainScreenBinding.inflate(inflater,container,false)


        viewModel.postlarListesi.observe(viewLifecycleOwner,{
            binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
            val adapter=MainAdapter(requireContext(),it)
            binding.recyclerView.adapter=adapter
        })



        return binding.root
    }

}