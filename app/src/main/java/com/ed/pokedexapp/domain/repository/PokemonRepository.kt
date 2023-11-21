package com.ed.pokedexapp.domain.repository

import com.ed.pokedexapp.domain.model.Pokemon
import com.ed.pokedexapp.domain.model.PokemonDetail
import com.ed.pokedexapp.util.Resource

interface PokemonRepository {
    suspend fun getPokemons(): Resource<List<Pokemon>>
    suspend fun getPokemonDetail(pokemonName:String): Resource<PokemonDetail>
}