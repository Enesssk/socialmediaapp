package com.example.socialmediaapp.ui.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.socialmediaapp.databinding.FragmentEntranceBinding
import dagger.hilt.android.AndroidEntryPoint

class EntranceFragment : Fragment() {

    private lateinit var binding:FragmentEntranceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentEntranceBinding.inflate(inflater,container,false)


        binding.buttonGetStarted.setOnClickListener {
            Navigation.findNavController(it).navigate(
                EntranceFragmentDirections.actionEntranceFragment2ToFragmentLogin()
            )
        }



        return binding.root
    }


}