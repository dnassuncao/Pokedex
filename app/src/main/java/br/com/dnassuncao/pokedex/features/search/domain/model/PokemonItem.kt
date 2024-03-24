package br.com.dnassuncao.pokedex.features.search.domain.model

import br.com.dnassuncao.pokedex.core.PokemonCategory

data class PokemonItem(
    val id: Int,
    val name: String,
    val image: String,
    val category: PokemonCategory
)