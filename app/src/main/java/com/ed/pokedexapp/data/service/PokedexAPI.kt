package com.ed.pokedexapp.data.service

import com.ed.pokedexapp.data.service.dto.PokemonDetailListDto
import com.ed.pokedexapp.data.service.dto.PokemonListDto
import com.ed.pokedexapp.domain.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexAPI {

//pokemon?limit=2&offset=0
    @GET("pokemon?limit=220&offset=0")
    suspend fun getPokemonList(
    ) : Response<PokemonListDto>

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonItems(
        @Path("pokemonName") pokemonName:String
    ) : Response<PokemonDetailListDto>





    /*
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit:Int,
        @Query("offset") offset:Int
    ) : Response<PokemonListDto>*/
}