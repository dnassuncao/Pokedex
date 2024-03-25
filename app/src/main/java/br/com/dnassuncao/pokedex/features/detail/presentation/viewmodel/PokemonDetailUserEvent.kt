package br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel

sealed class PokemonDetailUserEvent {
    data class OnInitScreen(val pokemonId: String) : PokemonDetailUserEvent()
}
