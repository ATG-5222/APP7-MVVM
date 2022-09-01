package com.example.app7_mvvm

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getPokemonList(@Url url:String): Response<PokemonListResult>
}