package com.ed.pokedexapp.domain.use_case.get_pokemons

import com.ed.pokedexapp.data.mappers.toPokemon
import com.ed.pokedexapp.data.service.PokedexAPI
import com.ed.pokedexapp.domain.model.Pokemon
import com.ed.pokedexapp.util.Resource
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(val pokemonApi:PokedexAPI) {

    suspend fun executeGetPokemons():Resource<List<Pokemon>>{
        return try {
            val response=pokemonApi.getPokemonList()
            if(response?.isSuccessful==true){
                response.body()?.let{
                    return@let Resource.success(it.results.map { it.toPokemon() })
                }?: Resource.error("Body boş geldi!",null)
            } else {
                Resource.error("Response successful değil!",null)
            }
        } catch (e: Exception) {
            Resource.error("Bütün olay patladı!",null)
        }
    }
}