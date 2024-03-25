package br.com.dnassuncao.pokedex.features.detail.domain.model

import br.com.dnassuncao.pokedex.core.PokemonCategory

data class PokemonDetail(
    val id: Int,
    val name: String,
    val image: String,
    val experience: Int? = 0,
    val weight: Int? = 0,
    val height: Int? = 0,
    val category: PokemonCategory,
)