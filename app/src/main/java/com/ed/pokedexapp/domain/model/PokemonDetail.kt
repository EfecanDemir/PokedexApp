package com.ed.pokedexapp.domain.model

import com.ed.pokedexapp.data.service.dto.Ability
import com.ed.pokedexapp.data.service.dto.Form
import com.ed.pokedexapp.data.service.dto.Gameİndice
import com.ed.pokedexapp.data.service.dto.Move
import com.ed.pokedexapp.data.service.dto.Species
import com.ed.pokedexapp.data.service.dto.Sprites
import com.ed.pokedexapp.data.service.dto.Stat
import com.ed.pokedexapp.data.service.dto.Type

data class PokemonDetail(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val game_indices: List<Gameİndice>,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_abilities: List<Any>,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)