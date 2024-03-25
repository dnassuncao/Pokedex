package br.com.dnassuncao.pokedex.features.detail.domain.model

data class PokemonDetail(
    val name: String,
    val image: String,
    val experience: Int? = 0,
    val weight: Int? = 0,
    val height: Int? = 0,
)