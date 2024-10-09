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
import com.example.myrealmeal.ui.adapter.RecipeFavoriteAdapter
import com.example.myrealmeal.viewModel.MainViewModel

class RecipeDetailFragment : Fragment() {

    private lateinit var binding: FragmentRecipeDetailBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var recipeAdapter: RecipeFavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        mainViewModel.currentRecipe.observe(viewLifecycleOwner) {
            binding.ivPancake.load(it.image)
            binding.tvPreparation.text = it.preparation

            if(it.halal){
                binding.ibHalal.load(R.drawable.halal)
            } else {
                binding.ibHalal.visibility = View.GONE
            }

            if(it.veggie){
                binding.ivVeggie.load(R.drawable.veggie)
            } else {
                binding.ivVeggie.visibility = View.GONE
            }

            binding.tvTime.text = it.time
           // binding.rvIngredients.text = it.ingredients.joinToString(", ") { it.name }
            // binding.rvIngredients.text = it.ingredients[0].name
            binding.tvCalories.text = it.calories.toString()
            binding.tvCarbs.text = it.carbs.toString()
            binding.tvProtein.text = it.protein.toString()
            binding.tvFat.text = it.fat.toString()

            binding.ibFav.setOnClickListener {
                mainViewModel.currentRecipe.value?.let {
                    binding.ibFav.setImageResource(if (it.favorite) R.drawable.baseline_favorite_24 else R.drawable.baseline_favorite_border_24)
                    if (it.favorite) {
                        mainViewModel.insertFavorite(it.apply { favorite = false })
                    } else {
                        mainViewModel.insertFavorite(it.apply { favorite = true })
                    }
                }

        }

        binding.tvRezeptName.text = mainViewModel.currentRecipe.value?.name


        if(mainViewModel.currentRecipe.value != null){  // führt es nur aus, wenn das image nicht null ist
            binding.ivPancake.load(mainViewModel.currentRecipe.value!!.image)
        }

        mainViewModel.currentRecipe.value?.let {  //let führt es nur aus, wenn das image nicht null ist
            binding.ivPancake.load(it.image)
        }


    }


}
}