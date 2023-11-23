package com.ed.pokedexapp.data.mappers

import com.ed.pokedexapp.data.service.dto.PokemonDetailListDto
import com.ed.pokedexapp.domain.model.PokemonDetail

fun PokemonDetailListDto.toPokemonDetail(): PokemonDetail {
    return PokemonDetail(
        abilities= abilities,
        base_experience= base_experience,
        forms= forms,
        game_indices= game_indices,
        height= height,
        held_items= held_items,
        id= id,
        is_default= is_default,
        location_area_encounters= location_area_encounters,
        moves= moves,
        name= name,
        order= order,
        past_abilities= past_abilities,
        past_types= past_types,
        species= species,
        sprites= sprites,
        stats= stats,
        types= types,
        weight= weight
    )
}