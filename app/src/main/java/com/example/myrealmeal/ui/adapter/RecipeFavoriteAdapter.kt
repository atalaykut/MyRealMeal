package com.example.myrealmeal.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myrealmeal.R
import com.example.myrealmeal.data.database.Meals
import com.example.myrealmeal.databinding.ItemRecipeBinding
import com.example.myrealmeal.viewModel.MainViewModel

class RecipeFavoriteAdapter (

    private val recipes: List<Meals>,
    private val mainViewModel: MainViewModel

) : RecyclerView.Adapter<RecipeFavoriteAdapter.RecipeViewHolder>(){
    inner class RecipeViewHolder(val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeFavoriteAdapter.RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.binding.tvRecipeName.text = recipe.name
        holder.binding.tvZeit.text = recipe.time
        holder.binding.Ernaehrungsform.text = recipe.veggie.toString()
        holder.binding.ivWishlistImage.load(recipe.image)

       /* holder.binding.recipeFrame.setOnClickListener {
            mainViewModel.setCurrentRecipe(recipe)
            holder.itemView.findNavController().navigate(R.id.action_recipeFragment_to_recipeDetailFragment)
        } */
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}

