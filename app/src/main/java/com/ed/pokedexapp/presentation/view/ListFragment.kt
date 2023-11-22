package com.ed.pokedexapp.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.ed.pokedexapp.R
import com.ed.pokedexapp.databinding.FragmentListBinding
import com.ed.pokedexapp.domain.model.Pokemon
import com.ed.pokedexapp.presentation.viewmodel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment :Fragment(), RecyclerViewAdapter.Listener{


    private var _binding: FragmentListBinding? = null
    private val binding get()= _binding!!
    private var pokemonAdapter = RecyclerViewAdapter(arrayListOf(),this)
    private lateinit var viewModel : PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        val gridLayoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.layoutManager = gridLayoutManager


        viewModel.loadData()

        observeLiveData()

        binding.recyclerView.adapter = pokemonAdapter

        val imageView = view.findViewById<ImageView>(R.id.ivFilter)
        if (imageView.tag == null) {
            imageView.tag = "circle_background"
        }

        imageView.setOnClickListener {
            val newDrawableId = if (imageView.tag == "circle_background") {
                R.drawable.circle_background_tag
            } else {
                R.drawable.circle_background
            }

            imageView.setImageResource(newDrawableId)

            imageView.tag = if (newDrawableId == R.drawable.circle_background) {
                "circle_background"
            } else {
                "circle_background_tag"
            }
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (imageView.tag == "circle_background") {
                    pokemonAdapter.filterByName(newText)
                }else{
                    pokemonAdapter.filterByHashtag(newText)
                }
                return true
            }
        })
    }

    private fun observeLiveData() {
        viewModel.pokemonList.observe(viewLifecycleOwner, Observer {pokemons ->
            Log.d("ListFragment", "Data changed: ${pokemons.data}")
            binding.pokemonErrorText.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            pokemonAdapter = RecyclerViewAdapter(ArrayList(pokemons.data ?: arrayListOf()), this@ListFragment)
            binding.recyclerView.adapter = pokemonAdapter
        })


        viewModel.pokemonError.observe(viewLifecycleOwner, Observer {error ->
            error.data?.let {
                if (it) {
                    binding.pokemonErrorText.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                } else {
                    binding.pokemonErrorText.visibility = View.GONE
                }
            }

        })

        viewModel.pokemonLoading.observe(viewLifecycleOwner, Observer { loading ->
            loading.data?.let {
                if(it) {
                    binding.pokemonProgressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                    binding.pokemonErrorText.visibility = View.GONE
                } else {
                    binding.pokemonProgressBar.visibility = View.GONE
                }
            }

        })
    }

    override fun onResume() {
        super.onResume()
        binding.searchView.setQuery("", false)
    }

    override fun onItemClick(pokemon: Pokemon) {
        //Toast.makeText(requireContext(),"Clicked on: ${pokemon.name}", Toast.LENGTH_SHORT).show()
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(pokemon.name)
        Navigation.findNavController(requireView()).navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}