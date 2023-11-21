package com.ed.pokedexapp.data.service.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationV(
    @SerialName("black-white") val blackwhite: BlackWhite
)