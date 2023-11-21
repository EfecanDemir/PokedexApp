package com.ed.pokedexapp.data.service.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Versions(
    @SerialName("generation-i") val generationi: Generationİ,
    @SerialName("generation-ii") val generationii: Generationİi,
    @SerialName("generation-iii") val generationiii: Generationİii,
    @SerialName("generation-iv") val generationiv: Generationİv,
    @SerialName("generation-v") val generationv: GenerationV,
    @SerialName("generation-vi") val generationvi: GenerationVi,
    @SerialName("generation-vii") val generationvii: GenerationVii,
    @SerialName("generation-viii") val generationviii: GenerationViii
)