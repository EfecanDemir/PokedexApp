package com.ed.pokedexapp.presentation.detail

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.transition.Transition
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.ed.pokedexapp.R
import com.ed.pokedexapp.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DetailViewModel


    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.ivBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

        val incomingPokemonName = args.pokemonName

        viewModel.getPokemonDetail(incomingPokemonName)

        viewModel.pokemon.observe(viewLifecycleOwner, Observer {

            binding.tvPokemonNameTitle.text = it.data?.name?.capitalize()
            val formattedNumber = String.format("#%03d", it.data?.id)
            binding.tvPokemonNumberTitle.text=formattedNumber
            /*
            it.data?.height.toString()
            it.data?.weight.toString()
            it.data?.stats.toString()
            it.data?.stats?.get(0)?.base_stat.toString() //hp
            it.data?.stats?.get(1)?.base_stat.toString() //attack
            it.data?.stats?.get(2)?.base_stat.toString() //defense
            it.data?.stats?.get(3)?.base_stat.toString() //special-attack
            it.data?.stats?.get(4)?.base_stat.toString() //special-defense
            it.data?.stats?.get(5)?.base_stat.toString() //speed
            */

            val backgroundColorResId = com.google.android.material.R.color.m3_sys_color_dark_background
            binding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), backgroundColorResId))

            val number = it.data?.id.toString()
            val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$number.png"

            Glide.with(requireContext())
                .load(imageUrl)
                .into(binding.ivDetailPokemon)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
