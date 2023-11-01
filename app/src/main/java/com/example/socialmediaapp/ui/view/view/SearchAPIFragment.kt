package com.example.socialmediaapp.ui.view.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.socialmediaapp.data.Model.ImageResponse
import com.example.socialmediaapp.databinding.FragmentSearchAPIBinding

import com.example.socialmediaapp.ui.view.adapter.SearchAdapter
import com.example.socialmediaapp.ui.view.util.Resource
import com.example.socialmediaapp.ui.view.util.Status
import com.example.socialmediaapp.ui.view.viewmodel.LoginViewModel
import com.example.socialmediaapp.ui.view.viewmodel.SearchViewModel
import com.example.socialmediaapp.ui.view.viewmodel.UploadFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SearchAPIFragment @Inject constructor(var searchAdapter: SearchAdapter): Fragment() {

    private lateinit var binding: FragmentSearchAPIBinding
    private lateinit var viewmodel: SearchViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding= FragmentSearchAPIBinding.inflate(inflater,container,false)
        viewmodel=ViewModelProvider(requireActivity()).get(SearchViewModel::class.java)


        var job: Job? = null

        binding.searchText.addTextChangedListener {
            job?.cancel()
            job=lifecycleScope.launch{
                delay(1000)
                if(it.toString().isEmpty()){
                    try {
                        viewmodel.searchImage(it!!.toString())
                    }catch (e:java.lang.Exception){
                        e.printStackTrace()
                    }

                }
            }
        }
        observeToResult()
        binding.imageRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.imageRecyclerView.adapter=searchAdapter

        return binding.root
    }

    fun observeToResult(){
        viewmodel.imageList.observe(viewLifecycleOwner, Observer {
            when (it.status) {

                Status.SUCCESS -> {

                    val urls = it.data?.hits?.map { imageResult -> imageResult.previewURL }
                    searchAdapter.list = urls ?: listOf()
                    binding.progressBar.visibility = View.GONE

                }

                Status.ERROR -> {

                    Toast.makeText(requireContext(),it.message ?: "Error",Toast.LENGTH_LONG).show()
                        binding.progressBar.visibility = View.GONE

                }

                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

            }
        })
    }


}