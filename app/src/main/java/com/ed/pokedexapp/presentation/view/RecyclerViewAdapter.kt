package com.ed.pokedexapp.presentation.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ed.pokedexapp.databinding.RecyclerRowBinding
import com.ed.pokedexapp.domain.model.Pokemon

class RecyclerViewAdapter(private val pokemonList:ArrayList<Pokemon>,private val listener:Listener): RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    private var filteredList: List<Pokemon> = pokemonList.toList()
    interface Listener {
        fun onItemClick(pokemon: Pokemon)
    }
    fun filter(text: String?) {
        text?.let {
            filteredList = pokemonList.filter { pokemon ->
                pokemon.name.contains(text, ignoreCase = true)
            }
            notifyDataSetChanged()
        }
    }
    class RowHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val itemBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(itemBinding)
    }
    override fun getItemCount(): Int {
        return filteredList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val pokemon = filteredList[position]

        holder.itemView.setOnClickListener {
            //listener.onItemClick(pokemon)
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(pokemon.name)
            Navigation.findNavController(it).navigate(action)
        }
        holder.binding.pokemonNameText.text = pokemon.name.capitalize()
        val number = pokemon.url.split("/").filter { it.isNotEmpty() }.lastOrNull()?.toIntOrNull()
        val formattedNumber = String.format("#%03d", number)
        holder.binding.pokemonNumberText.text = formattedNumber
        val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$number.png"


        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.binding.ivPokemon)
    }
}