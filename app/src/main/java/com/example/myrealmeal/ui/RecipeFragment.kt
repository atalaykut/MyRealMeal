package com.example.myrealmeal.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.myrealmeal.databinding.FragmentRecipeBinding
import com.example.myrealmeal.ui.adapter.RecipeAdapter

import com.example.myrealmeal.viewModel.MainViewModel


class RecipeFragment : Fragment() {

    private lateinit var binding: FragmentRecipeBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Buttons einbauen die "navigieren" sollen

        mainViewModel.recipes.observe(viewLifecycleOwner) {
           Log.d("RecipeFragment", "onViewCreated: ${it.size}")
            binding.rvRecipesList.adapter = RecipeAdapter(recipes = it, mainViewModel)
        }

    }

}