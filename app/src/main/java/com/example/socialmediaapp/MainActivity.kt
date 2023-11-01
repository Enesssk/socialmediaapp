package com.example.socialmediaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.socialmediaapp.databinding.ActivityMainBinding
import com.example.socialmediaapp.ui.view.FragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    @Inject
    lateinit var fragmentFactory : FragmentFactory




    //8bUzm5hfLjphEKjhsQRgpAkkCTd1LikacAqpQxYfDWrocgfcVGGEijef
    //GET https://api.pexels.com/v1/search
    //https://api.pexels.com/v1/ url

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory=fragmentFactory
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottom,navHostFragment.navController)

        

    }
}