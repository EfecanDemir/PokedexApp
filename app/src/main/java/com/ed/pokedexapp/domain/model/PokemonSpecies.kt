package com.ed.pokedexapp.domain.model

import com.ed.pokedexapp.data.service.dto.Color
import com.ed.pokedexapp.data.service.dto.EggGroup
import com.ed.pokedexapp.data.service.dto.EvolutionChain
import com.ed.pokedexapp.data.service.dto.EvolvesFromSpecies
import com.ed.pokedexapp.data.service.dto.FlavorTextEntry
import com.ed.pokedexapp.data.service.dto.FormDescription
import com.ed.pokedexapp.data.service.dto.Genera
import com.ed.pokedexapp.data.service.dto.Generation
import com.ed.pokedexapp.data.service.dto.GrowthRate
import com.ed.pokedexapp.data.service.dto.Name
import com.ed.pokedexapp.data.service.dto.PokedexNumber
import com.ed.pokedexapp.data.service.dto.Shape
import com.ed.pokedexapp.data.service.dto.Variety

data class PokemonSpecies(
    val base_happiness: Int?,
    val capture_rate: Int?,
    val color: Color?,
    val egg_groups: List<EggGroup>?,
    val evolution_chain: EvolutionChain?,
    val evolves_from_species: EvolvesFromSpecies?,
    val flavor_text_entries: List<FlavorTextEntry>?,
    val form_descriptions: List<FormDescription>?,
    val forms_switchable: Boolean?,
    val gender_rate: Int?,
    val genera: List<Genera>,
    val generation: Generation?,
    val growth_rate: GrowthRate?,
    val habitat: Any?,
    val has_gender_differences: Boolean?,
    val hatch_counter: Int?,
    val id: Int?,
    val is_baby: Boolean?,
    val is_legendary: Boolean?,
    val is_mythical: Boolean?,
    val name: String?,
    val names: List<Name>?,
    val order: Int?,
    val pal_park_encounters: List<Any>?,
    val pokedex_numbers: List<PokedexNumber>?,
    val shape: Shape?,
    val varieties: List<Variety>?
)