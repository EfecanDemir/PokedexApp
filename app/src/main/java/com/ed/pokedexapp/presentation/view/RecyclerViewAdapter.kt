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
    interface Listener {
        fun onItemClick(pokemon: Pokemon)
    }
    private val colors: Array<String> = arrayOf("#13bd27","#29c1e1","#b129e1","#d3df13","#f6bd0c","#a1fb93","#0d9de3","#ffe48f")

    class RowHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val itemBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(itemBinding)
    }
    override fun getItemCount(): Int {
        return pokemonList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val pokemon = pokemonList.get(position)

        holder.itemView.setOnClickListener {
            //listener.onItemClick(pokemon)
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(pokemon.name)
            Navigation.findNavController(it).navigate(action)
        }
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
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