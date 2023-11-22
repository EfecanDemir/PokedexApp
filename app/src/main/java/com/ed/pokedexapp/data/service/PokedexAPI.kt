package com.ed.pokedexapp.data.service

import com.ed.pokedexapp.data.service.dto.PokemonDetailListDto
import com.ed.pokedexapp.data.service.dto.PokemonListDto
import com.ed.pokedexapp.domain.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexAPI {

    @GET("pokemon?limit=1000&offset=0")
    suspend fun getPokemonList(
    ) : Response<PokemonListDto>

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonItems(
        @Path("pokemonName") pokemonName:String
    ) : Response<PokemonDetailListDto>
}