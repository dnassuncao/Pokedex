package br.com.dnassuncao.pokedex.features.search.presentation.viewmodel

sealed class SearchPokemonNavigationRequest {
    data class PokemonDetailScreen(val pokemonId: String) : SearchPokemonNavigationRequest()
}
