package com.ed.pokedexapp.data.mappers

import com.ed.pokedexapp.domain.model.Pokemon
import com.ed.pokedexapp.data.service.dto.Result

fun Result.toPokemon():Pokemon{
    return Pokemon(
        name=name,
        url=url
    )
}