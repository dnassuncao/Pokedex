package br.com.dnassuncao.pokedex.bottomnav

import Screens
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(Screens.Home.route) {

        }
        composable(Screens.Region.route) {

        }
        composable(Screens.Favorite.route) {

        }
        composable(Screens.Profile.route) {

        }
    }
}