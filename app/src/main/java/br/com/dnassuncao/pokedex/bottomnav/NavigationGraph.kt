package br.com.dnassuncao.pokedex.bottomnav

import Screens
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.dnassuncao.pokedex.features.search.presentation.ui.SearchPokemonScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Search.route
    ) {
        composable(Screens.Search.route) {
            SearchPokemonScreen(navController = navController)
        }
        composable(Screens.Region.route) {

        }
        composable(Screens.Favorite.route) {

        }
        composable(Screens.Profile.route) {

        }
    }
}