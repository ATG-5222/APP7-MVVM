package com.example.app7_mvvm

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.app7_mvvm.databinding.ActivityPokemonitemBinding

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ActivityPokemonitemBinding.bind(view)

    fun bind(item:PokemonData){
        binding.tvName.text = item.name
    }
}