package com.example.socialmediaapp.ui.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.socialmediaapp.databinding.FragmentMainScreenBinding
import com.example.socialmediaapp.databinding.FragmentProfileBinding
import com.example.socialmediaapp.ui.view.viewmodel.LoginViewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewmodel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewmodel : LoginViewModel by viewModels()
        viewmodel=tempViewmodel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentProfileBinding.inflate(inflater,container,false)

        binding.exitButton.setOnClickListener {
            viewmodel.cikisYap(it)
        }


        return binding.root
    }


}