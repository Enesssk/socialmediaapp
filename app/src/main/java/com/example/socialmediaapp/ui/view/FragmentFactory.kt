package com.example.socialmediaapp.ui.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.example.socialmediaapp.ui.view.adapter.SearchAdapter
import com.example.socialmediaapp.ui.view.view.SearchAPIFragment
import javax.inject.Inject

class FragmentFactory @Inject constructor(
    private val searchAdapter: SearchAdapter,
) : FragmentFactory() {


    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            SearchAPIFragment::class.java.name -> SearchAPIFragment(searchAdapter)
            else -> super.instantiate(classLoader, className)
        }
    }
}