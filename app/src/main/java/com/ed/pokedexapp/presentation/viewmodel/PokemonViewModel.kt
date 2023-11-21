package com.ed.pokedexapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ed.pokedexapp.domain.model.Pokemon
import com.ed.pokedexapp.domain.repository.PokemonRepository
import com.ed.pokedexapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(val pokemonRepository: PokemonRepository):ViewModel(){
    val pokemonList= MutableLiveData<Resource<List<Pokemon>>>()
    val pokemonError=MutableLiveData<Resource<Boolean>>()
    val pokemonLoading=MutableLiveData<Resource<Boolean>>()

    val exceptionHandler= CoroutineExceptionHandler{coroutineContext, throwable ->
        println(throwable.localizedMessage)
        pokemonError.value=Resource.error(throwable.localizedMessage ?: "Error!",true)
    }

    fun loadData(){
        pokemonLoading.value=Resource.loading(true)

        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val resource=pokemonRepository.getPokemons()
            withContext(Dispatchers.Main){
                resource.data?.let{
                    pokemonLoading.value=Resource.loading(false)
                    pokemonError.value = Resource.error("",false)
                    pokemonList.value = resource
                }
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
    }
}