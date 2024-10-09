package com.example.myrealmeal.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.myrealmeal.R
import com.example.myrealmeal.databinding.FragmentRecipeDetailBinding
import com.example.myrealmeal.viewModel.MainViewModel

class RecipeDetailFragment : Fragment() {

    private lateinit var binding: FragmentRecipeDetailBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvRezeptName.text = mainViewModel.currentRecipe.value?.name

        if(mainViewModel.currentRecipe.value != null){  // führt es nur aus, wenn das image nicht null ist
            binding.ivPancake.load(mainViewModel.currentRecipe.value!!.image)
        }

        mainViewModel.currentRecipe.value?.let {  //let führt es nur aus, wenn das image nicht null ist
            binding.ivPancake.load(it.image)
        }


    }


}