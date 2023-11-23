package com.ed.pokedexapp.data.mappers

import com.ed.pokedexapp.data.service.dto.PokemonSpeciesListDto
import com.ed.pokedexapp.domain.model.PokemonSpecies

fun PokemonSpeciesListDto.toPokemonSpecies(): PokemonSpecies {
    return PokemonSpecies(
        base_happiness = base_happiness,
        capture_rate= capture_rate,
        color= color,
        egg_groups= egg_groups,
        evolution_chain= evolution_chain,
        evolves_from_species= evolves_from_species,
        flavor_text_entries= flavor_text_entries,
        form_descriptions= form_descriptions,
        forms_switchable= forms_switchable,
        gender_rate= gender_rate,
        genera= genera,
        generation= generation,
        growth_rate= growth_rate,
        habitat= habitat,
        has_gender_differences= has_gender_differences,
        hatch_counter= hatch_counter,
        id= id,
        is_baby= is_baby,
        is_legendary= is_legendary,
        is_mythical= is_mythical,
        name= name,
        names= names,
        order= order,
        pal_park_encounters= pal_park_encounters,
        pokedex_numbers= pokedex_numbers,
        shape= shape,
        varieties= varieties
    )
}