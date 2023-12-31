package com.ed.pokedexapp.data.service

import com.ed.pokedexapp.data.service.dto.PokemonDetailListDto
import com.ed.pokedexapp.data.service.dto.PokemonListDto
import com.ed.pokedexapp.data.service.dto.PokemonSpeciesListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexAPI {

    @GET("pokemon?limit=1000&offset=0")
    suspend fun getPokemonList(
    ) : Response<PokemonListDto>

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonItems(
        @Path("pokemonName") pokemonName:String
    ) : Response<PokemonDetailListDto>

    @GET("pokemon-species/{pokemonName}")
    suspend fun getPokemonSpeciesItems(
        @Path("pokemonName") pokemonName:String
    ) : Response<PokemonSpeciesListDto>
}