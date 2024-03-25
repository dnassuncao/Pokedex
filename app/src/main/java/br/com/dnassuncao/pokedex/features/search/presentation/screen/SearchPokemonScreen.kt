package br.com.dnassuncao.pokedex.features.search.presentation.screen

import Screens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import br.com.dnassuncao.pokedex.features.search.presentation.viewmodel.SearchPokemonNavigationRequest
import br.com.dnassuncao.pokedex.features.search.presentation.viewmodel.SearchPokemonUserEvent
import br.com.dnassuncao.pokedex.features.search.presentation.viewmodel.SearchPokemonViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchPokemonScreen(
    navController: NavHostController,
    viewModel: SearchPokemonViewModel = koinViewModel()
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(key1 = Unit) {
        viewModel.onUserEvent(SearchPokemonUserEvent.OnSearchPokemon())

        viewModel.navigationRequest
            .flowWithLifecycle(lifecycle = lifecycle, Lifecycle.State.STARTED)
            .onEach { request ->
                handleNavigationRequestChange(request, navController)
            }.launchIn(this)
    }

    val state = viewModel.uiState.collectAsState()

    SearchPokemonContent(
        pokemonPager = state.value.pokemons,
        onUiEvent = {
            viewModel.onUserEvent(event = it)
        }
    )
}

private fun handleNavigationRequestChange(
    request: SearchPokemonNavigationRequest,
    navController: NavHostController
) {
    when (request) {
        is SearchPokemonNavigationRequest.PokemonDetailScreen -> navController.navigate(
            Screens.Detail.route.replace("{pokemonId}", request.pokemonId)
        )
    }
}