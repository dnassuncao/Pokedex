package br.com.dnassuncao.pokedex.features.search.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavHostController
import br.com.dnassuncao.pokedex.features.search.presentation.viewmodel.SearchPokemonUserEvent
import br.com.dnassuncao.pokedex.features.search.presentation.viewmodel.SearchPokemonViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchPokemonScreen(
    navController: NavHostController,
    viewModel: SearchPokemonViewModel = koinViewModel()
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(key1 = Unit) {
        viewModel.onUserEvent(SearchPokemonUserEvent.OnSearchPokemon())
    }

    val state = viewModel.uiState.collectAsState().value

    SearchPokemonContent(
        pokemonPager = state.pokemons,
        onUiEvent = {
            viewModel.onUserEvent(event = it)
        }
    )
}

//private fun handleNavigationRequestChange(
//    request: PokemonListNavigationRequest,
//    navController: NavHostController
//) {
//    when (request) {
//        is PokemonListNavigationRequest.PokemonDetailScreen -> navController.navigate(
//            Screen.Detail.route.replace("{pokemonId}", request.pokemonId)
//        )
//    }
//}