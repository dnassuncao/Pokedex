package br.com.dnassuncao.pokedex.features.detail.data.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("base_experience")
    val experience: Int,

    @SerializedName("weight")
    val weight: Int,

    @SerializedName("height")
    val height: Int,

    @SerializedName("name")
    val name: String,

)