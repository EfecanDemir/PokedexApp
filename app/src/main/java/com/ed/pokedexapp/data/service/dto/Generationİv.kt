package com.ed.pokedexapp.data.service.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Generationİv(
    @SerialName("diamond-pearl") val diamondpearl: DiamondPearl,
    @SerialName("heartgold-soulsilver") val heartgoldsoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)