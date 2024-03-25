package br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel

import br.com.dnassuncao.pokedex.features.detail.domain.model.PokemonDetail
import br.com.dnassuncao.pokedex.ui.common.UiStatus

data class PokemonDetailUiState(
    val status: UiStatus = UiStatus.Loading,
    val pokemon: PokemonDetail? = null
)
