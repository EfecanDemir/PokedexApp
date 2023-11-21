package com.ed.pokedexapp.data.mappers

import com.ed.pokedexapp.data.service.dto.Form
import com.ed.pokedexapp.data.service.dto.Gameİndice
import com.ed.pokedexapp.data.service.dto.Move
import com.ed.pokedexapp.data.service.dto.PokemonDetailListDto
import com.ed.pokedexapp.data.service.dto.Result
import com.ed.pokedexapp.data.service.dto.Species
import com.ed.pokedexapp.data.service.dto.Sprites
import com.ed.pokedexapp.data.service.dto.Stat
import com.ed.pokedexapp.data.service.dto.Type
import com.ed.pokedexapp.domain.model.Pokemon
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