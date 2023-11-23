package com.ed.pokedexapp.data.di

import com.ed.pokedexapp.data.repository.PokemonRepositoryImpl
import com.ed.pokedexapp.data.service.PokedexAPI
import com.ed.pokedexapp.domain.repository.PokemonRepository
import com.ed.pokedexapp.domain.use_case.get_pokemon_detail.GetPokemonDetailsUseCase
import com.ed.pokedexapp.domain.use_case.get_pokemon_species.GetPokemonSpeciesUseCase
import com.ed.pokedexapp.domain.use_case.get_pokemons.GetPokemonsUseCase
import com.ed.pokedexapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PokedexAppModule {

    @Singleton
    @Provides
    fun injectRetrofitAPI(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun createPokedexApi(retrofit: Retrofit): PokedexAPI {
        return retrofit.create(PokedexAPI::class.java)
    }

    @Singleton
    @Provides
    fun injectPokedexRepo(
        getPokemonsUseCase: GetPokemonsUseCase,
        getPokemonDetailsUseCase: GetPokemonDetailsUseCase,
        getPokemonSpeciesUseCase: GetPokemonSpeciesUseCase
    ) = PokemonRepositoryImpl(getPokemonsUseCase,getPokemonDetailsUseCase,getPokemonSpeciesUseCase) as PokemonRepository
}