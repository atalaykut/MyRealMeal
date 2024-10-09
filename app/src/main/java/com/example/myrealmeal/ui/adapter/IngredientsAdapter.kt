package com.example.myrealmeal.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrealmeal.data.database.Meals
import com.example.myrealmeal.databinding.ListItemIngredientsBinding
import com.example.myrealmeal.viewModel.MainViewModel

class IngredientsAdapter(
    private val recipes: List<Meals>,
    private val mainViewModel: MainViewModel
) : RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>(){

    inner class IngredientsViewHolder(val binding: ListItemIngredientsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientsAdapter.IngredientsViewHolder {
        val binding = ListItemIngredientsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        val recipe = recipes[position]
        recipe.ingredients.forEach {
            holder.binding.tvName.text = it.name
            holder.binding.tvAmount.text = it.amount.toString()
            holder.binding.tvUnit.text = it.unit
        }

    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}





