package com.ed.pokedexapp.data.service.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Generationİ(
    @SerialName("red-blue") val redblue: RedBlue,
    val yellow: Yellow
)