package com.example.app7_mvvm

import com.google.gson.annotations.SerializedName

data class PokemonListResult (
    @SerializedName("count") var count:Int,
    @SerializedName("results") var results:List<PokemonData>
)