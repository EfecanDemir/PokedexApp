package com.ed.pokedexapp.data.repository

import com.ed.pokedexapp.domain.model.Pokemon
import com.ed.pokedexapp.domain.model.PokemonDetail
import com.ed.pokedexapp.domain.repository.PokemonRepository
import com.ed.pokedexapp.domain.use_case.get_pokemon_detail.GetPokemonDetailsUseCase
import com.ed.pokedexapp.domain.use_case.get_pokemons.GetPokemonsUseCase
import com.ed.pokedexapp.util.Resource
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
) :PokemonRepository{
    override suspend fun getPokemons(): Resource<List<Pokemon>> {
        return getPokemonsUseCase.executeGetPokemons()
    }
    override suspend fun getPokemonDetail(pokemonName: String): Resource<PokemonDetail> {
        return getPokemonDetailsUseCase.executeGetPokemonDetails(pokemonName)
    }
}