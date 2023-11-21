package com.ed.pokedexapp.data.service.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVi(
    @SerialName("omegaruby-alphasapphire") val omegarubyalphasapphire: OmegarubyAlphasapphire,
    @SerialName("x-y") val xy: XY
)