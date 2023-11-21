package com.ed.pokedexapp.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ed.pokedexapp.domain.model.PokemonDetail
import com.ed.pokedexapp.domain.repository.PokemonRepository
import com.ed.pokedexapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {
    val pokemon = MutableLiveData<Resource<PokemonDetail>>()
    val pokemonLoading = MutableLiveData<Resource<Boolean>>()
    val pokemonError = MutableLiveData<Resource<Boolean>>()

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println(throwable.localizedMessage)
        pokemonError.value = Resource.error(throwable.localizedMessage ?: "Error!", true)
    }

    fun getPokemonDetail(pokemonName: String) {
        pokemonLoading.value = Resource.loading(true)

        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val resource = pokemonRepository.getPokemonDetail(pokemonName)
            withContext(Dispatchers.Main) {
                resource.data?.let {
                    pokemonLoading.value = Resource.loading(false)
                    pokemonError.value = Resource.error("", false)
                    pokemon.value = resource
                }
            }
        }
    }
}