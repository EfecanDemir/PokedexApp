package com.ed.pokedexapp.data.service.dto

import com.google.gson.JsonElement

data class PokemonListDto(
    val count: Long,
    val next: String,
    val previous: JsonElement? = null,
    val results: List<Result>
)


