package com.example.socialmediaapp.ui.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.socialmediaapp.databinding.FragmentLoginBinding
import com.example.socialmediaapp.ui.view.viewmodel.LoginViewModel

class FragmentLogin : Fragment() {

    private lateinit var binding:FragmentLoginBinding
    private lateinit var viewmodel:LoginViewModel

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
        binding= FragmentLoginBinding.inflate(inflater,container,false)

        binding.buttonSignUp.setOnClickListener {
            var email=binding.editTextTextPersonName.text.toString()
            var password=binding.editTextTextPersonName2.text.toString()

            viewmodel.kayitOl(email,password,requireContext(),it)
        }

        binding.buttonSignIn.setOnClickListener {
            var email=binding.editTextTextPersonName.text.toString()
            var password=binding.editTextTextPersonName2.text.toString()

            viewmodel.girisYap(email,password,requireContext(),it)
        }


        return binding.root
    }


}