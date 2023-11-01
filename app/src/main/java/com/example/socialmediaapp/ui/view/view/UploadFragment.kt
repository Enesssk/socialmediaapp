package com.example.socialmediaapp.ui.view.view
import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.socialmediaapp.data.Model.Post
import com.example.socialmediaapp.databinding.FragmentUploadBinding
import com.example.socialmediaapp.ui.view.adapter.MainAdapter
import com.example.socialmediaapp.ui.view.viewmodel.UploadFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

class UploadFragment : Fragment() {

    private lateinit var binding: FragmentUploadBinding
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private var selectedImage : Uri?=null
    private lateinit var viewModel:UploadFragmentViewModel

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
        binding= FragmentUploadBinding.inflate(inflater,container,false)




        registerLauncher()

        binding.imageViewAPI.setOnClickListener {
            Navigation.findNavController(it).navigate(UploadFragmentDirections.actionUploadFragmentToSearchAPIFragment())
        }

        binding.imageViewGaleri.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){

                if(ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_MEDIA_IMAGES)!=PackageManager.PERMISSION_GRANTED){
                    if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),Manifest.permission.READ_MEDIA_IMAGES)){
                        Snackbar.make(requireView(),"Permission needed for gallery",Snackbar.LENGTH_INDEFINITE).setAction("Give permission",{
                            //permissiongranted
                            permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
                        })
                    }else{
                        //permissiongranted
                        permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)

                    }
                }else{
                    val intent=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    activityResultLauncher.launch(intent)
                }

            }else{

                if(ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                    if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)){
                        Snackbar.make(requireView(),"Permission needed for gallery",Snackbar.LENGTH_INDEFINITE).setAction("Give permission",{
                            //permissiongranted
                            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                        })
                    }else{
                        //permissiongranted
                        permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)

                    }
                }else{
                    val intent=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    activityResultLauncher.launch(intent)
                }

            }
        }

        binding.saveButton.setOnClickListener {

            viewModel.kaydet(selectedImage!!,binding.commentText.text.toString(),requireView())

        }






        return binding.root
    }


    fun registerLauncher(){

        activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->

            if(result.resultCode==RESULT_OK){
                var intentFromResult=result.data
                if(intentFromResult!=null){
                    selectedImage=intentFromResult.data
                    binding.imageVIEW.setImageURI(selectedImage)
                }
            }
        }

       permissionLauncher=registerForActivityResult(ActivityResultContracts.RequestPermission()){result->

           if(result){
               var intentToGallery=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
               activityResultLauncher.launch(intentToGallery)
           }else{
               Toast.makeText(requireContext(),"Give Permission",Toast.LENGTH_LONG).show()
           }
       }
    }






}