package br.com.dnassuncao.pokedex.features.search.presentation.viewmodel

sealed class SearchPokemonUserEvent {
    data class OnItemClick(val pokemonId: Int) : SearchPokemonUserEvent()
    data class OnSearchPokemon(val pokemonName: String? = null) : SearchPokemonUserEvent()
}
