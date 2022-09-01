package com.example.app7_mvvm

import com.google.gson.annotations.SerializedName

data class PokemonData(
    @SerializedName("name") var name:String,
    @SerializedName("url") var url:String
)