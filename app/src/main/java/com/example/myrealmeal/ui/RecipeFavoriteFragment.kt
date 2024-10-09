package com.example.myrealmeal.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.myrealmeal.databinding.FragmentRecipeFavoriteBinding
import com.example.myrealmeal.ui.adapter.RecipeFavoriteAdapter
import com.example.myrealmeal.viewModel.MainViewModel


class RecipeFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentRecipeFavoriteBinding
    private val mainViewModel: MainViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getFavorites()
        mainViewModel.favoriteRecipes.observe(viewLifecycleOwner) {
            binding.rvFavRec.adapter = RecipeFavoriteAdapter(it, mainViewModel)
        }
    }
}