package com.ed.pokedexapp.presentation.detail

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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
            binding.tvWeightAmount.text="${(it.data?.weight!! / 10.0)} kg"
            binding.tvHeightAmount.text="${(it.data?.height!! / 10.0)} m"
            binding.hpBaseState.text="%03d".format(it.data?.stats?.get(0)?.base_stat)
            binding.atkBaseState.text="%03d".format(it.data?.stats?.get(1)?.base_stat)
            binding.defBaseState.text="%03d".format(it.data?.stats?.get(2)?.base_stat)
            binding.satkBaseState.text="%03d".format(it.data?.stats?.get(3)?.base_stat)
            binding.sdefBaseState.text="%03d".format(it.data?.stats?.get(4)?.base_stat)
            binding.spdBaseState.text="%03d".format(it.data?.stats?.get(5)?.base_stat)
            binding.pbHpBaseState.progress=it.data.stats.get(0).base_stat
            binding.pbAtkBaseState.progress=it.data.stats.get(1).base_stat
            binding.pbDefBaseState.progress=it.data.stats.get(2).base_stat
            binding.pbSatkBaseState.progress=it.data.stats.get(3).base_stat
            binding.pbSdefBaseState.progress=it.data.stats.get(4).base_stat
            binding.pbSpdBaseState.progress=it.data.stats.get(5).base_stat
            binding.tvAbilityText.text=it.data?.abilities?.get(0)?.ability?.name?.capitalize()

            val abilityList = it.data?.abilities
            binding.tvAbilityTextSecond.text = if (abilityList != null && abilityList.size > 1) {
                abilityList[1]?.ability?.name?.capitalize() ?: ""
            } else {
                ""
            }

            binding.statusType.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="type" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="type"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusNormal.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="normal" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="normal"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusFighting.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="fighting" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="fighting"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusFlying.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="flying" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="flying"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusGround.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="ground" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="ground"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusPoison.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="poison" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="poison"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusRock.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="rock" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="rock"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusBug.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="bug" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="bug"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusGhost.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="ghost" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="ghost"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusSteel.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="steel" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="steel"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusFire.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="fire" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="fire"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusWater.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="water" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="water"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusGrass.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="grass" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="grass"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusElectric.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="electric" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="electric"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusPsychic.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="psychic" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="psychic"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusIce.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="ice" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="ice"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusDragon.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="dragon" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="dragon"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusDark.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="dark" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="dark"){
                View.VISIBLE
            }else{
                View.GONE
            }
            binding.statusFairy.visibility=if(it.data?.types?.getOrNull(0)?.type?.name.toString()=="fairy" || it.data?.types?.getOrNull(1)?.type?.name.toString()=="fairy"){
                View.VISIBLE
            }else{
                View.GONE
            }

            val typeName = it.data?.types?.getOrNull(0)?.type?.name.toString()
            val backgroundColorResId = when (typeName) {
                "type" -> R.color.black
                "normal" -> R.color.normal
                "fighting" -> R.color.fighting
                "bug" -> R.color.bug
                "dark" -> R.color.dark
                "dragon" -> R.color.dragon
                "electric" -> R.color.electric
                "fairy" -> R.color.fairy
                "fire" -> R.color.fire
                "flying" -> R.color.flying
                "ghost" -> R.color.ghost
                "grass" -> R.color.grass
                "ground" -> R.color.ground
                "ice" -> R.color.ice
                "poison" -> R.color.poison
                "psychic" -> R.color.psychic
                "rock" -> R.color.rock
                "steel" -> R.color.steel
                "water" -> R.color.water
                else -> R.color.black
            }
            binding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), backgroundColorResId))
            binding.tvAboutTitle.setTextColor(ContextCompat.getColor(requireContext(), backgroundColorResId))
            binding.tvBaseStatsTitle.setTextColor(ContextCompat.getColor(requireContext(), backgroundColorResId))
            binding.tvHp.setTextColor(ContextCompat.getColor(requireContext(), backgroundColorResId))
            binding.tvAtk.setTextColor(ContextCompat.getColor(requireContext(), backgroundColorResId))
            binding.tvDef.setTextColor(ContextCompat.getColor(requireContext(), backgroundColorResId))
            binding.tvSatk.setTextColor(ContextCompat.getColor(requireContext(), backgroundColorResId))
            binding.tvSdef.setTextColor(ContextCompat.getColor(requireContext(), backgroundColorResId))
            binding.tvSpd.setTextColor(ContextCompat.getColor(requireContext(), backgroundColorResId))

            val pbHpBaseState = view.findViewById<ProgressBar>(R.id.pbHpBaseState)
            val pbAtkBaseState = view.findViewById<ProgressBar>(R.id.pbAtkBaseState)
            val pbDefBaseState = view.findViewById<ProgressBar>(R.id.pbDefBaseState)
            val pbSatkBaseState = view.findViewById<ProgressBar>(R.id.pbSatkBaseState)
            val pbSdefBaseState = view.findViewById<ProgressBar>(R.id.pbSdefBaseState)
            val pbSpdBaseState = view.findViewById<ProgressBar>(R.id.pbSpdBaseState)

            listOf(pbHpBaseState, pbAtkBaseState, pbDefBaseState, pbSatkBaseState, pbSdefBaseState, pbSpdBaseState)
                .forEach { progressBar ->
                    progressBar.progressTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), backgroundColorResId))
                }

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
