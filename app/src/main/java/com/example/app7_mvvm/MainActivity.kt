package com.example.app7_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app7_mvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var pkmnList:List<PokemonData>
    private lateinit var adapter:PokemonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchPokemonList()

    }

    private fun InitializaList(){
        adapter = PokemonListAdapter(pkmnList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchPokemonList(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getPokemonList("?offset=0&limit=968")
            val pokemonList = call.body()
            if(call.isSuccessful){
                //show Recyclerview
                Log.d("Salida",pokemonList!!.results.size.toString())
                pkmnList = pokemonList.results
                CoroutineScope(Dispatchers.Main).launch {InitializaList()}
            }else{
                //show error
            }
        }
    }

}