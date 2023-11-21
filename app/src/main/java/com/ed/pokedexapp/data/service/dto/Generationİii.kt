package com.ed.pokedexapp.data.service.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Generationİii(
    val emerald: Emerald,
    @SerialName("firered-leafgreen") val fireredleafgreen: FireredLeafgreen,
    @SerialName("ruby-sapphire") val rubysapphire: RubySapphire
)