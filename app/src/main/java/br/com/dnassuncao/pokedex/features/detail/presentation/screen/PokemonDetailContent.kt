package br.com.dnassuncao.pokedex.features.detail.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel.PokemonDetailUiState
import br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel.PokemonDetailUserEvent
import br.com.dnassuncao.pokedex.ui.common.UiStatus

@Composable
fun PokemonDetailContent(
    uiState: PokemonDetailUiState,
    onUiEvent: (event: PokemonDetailUserEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (val status = uiState.status) {
            UiStatus.Loading -> {
                // TODO: Show loading state
            }
            is UiStatus.Failed -> {
                // TODO: Show error state
            }
            UiStatus.Success -> {
                uiState.pokemon?.let { Text(text = it.name) }
            }
        }
    }
}