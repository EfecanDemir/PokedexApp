package com.ed.pokedexapp.domain.use_case.get_pokemon_detail

import com.ed.pokedexapp.data.mappers.toPokemonDetail
import com.ed.pokedexapp.data.service.PokedexAPI
import com.ed.pokedexapp.domain.model.PokemonDetail
import com.ed.pokedexapp.util.Resource
import java.io.IOError
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(private val pokedexAPI: PokedexAPI){

    suspend fun executeGetPokemonDetails(pokemonName:String):Resource<PokemonDetail>{
        return try{
            val response=pokedexAPI.getPokemonItems(pokemonName)
            if (response.isSuccessful){
                response.body()?.let{
                    return@let Resource.success(it.toPokemonDetail())
                } ?:Resource.error("Error",null)
            }else {
                Resource.error("Response error",null)
            }
        } catch (e: IOError) {
            Resource.error( "Could not reach internet",null)
        }
    }
}