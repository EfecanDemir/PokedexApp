package com.ed.pokedexapp.data.service.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVii(
    val icons: İcons,
    @SerialName("ultra-sun-ultra-moon") val ultrasunultramoon: UltraSunUltraMoon
)