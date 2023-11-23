package com.ed.pokedexapp.domain.use_case.get_pokemon_species

import com.ed.pokedexapp.data.mappers.toPokemonSpecies
import com.ed.pokedexapp.data.service.PokedexAPI
import com.ed.pokedexapp.domain.model.PokemonSpecies
import com.ed.pokedexapp.util.Resource
import java.io.IOError
import javax.inject.Inject

class GetPokemonSpeciesUseCase @Inject constructor(private val pokedexAPI: PokedexAPI){

    suspend fun executeGetPokemonSpecies(pokemonName:String): Resource<PokemonSpecies> {
        return try{
            val response=pokedexAPI.getPokemonSpeciesItems(pokemonName)
            if (response.isSuccessful){
                response.body()?.let{
                    return@let Resource.success(it.toPokemonSpecies())
                } ?: Resource.error("Error",null)
            }else {
                Resource.error("Response error",null)
            }
        } catch (e: IOError) {
            Resource.error( "Could not reach internet",null)
        }
    }
}