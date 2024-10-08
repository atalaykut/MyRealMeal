package com.example.myrealmeal.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myrealmeal.R
import com.example.myrealmeal.databinding.FragmentRecipeBinding
import com.example.myrealmeal.databinding.FragmentRecipeFavoriteBinding


class RecipeFragment : Fragment() {

    private lateinit var binding: FragmentRecipeBinding

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

    }

}