package br.com.dnassuncao.pokedex.features.detail.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel.PokemonDetailUserEvent
import br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel.PokemonDetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel = koinViewModel(),
    pokemonId: String,
    navController: NavHostController
) {
    val state = viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.onUserEvent(event = PokemonDetailUserEvent.OnInitScreen(pokemonId))
    }

    PokemonDetailContent(
        uiState = state.value,
        onUiEvent = {}
    )
}