package br.com.dnassuncao.pokedex

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import br.com.dnassuncao.pokedex.bottomnav.BottomNavigationBar
import br.com.dnassuncao.pokedex.bottomnav.NavigationGraph
import br.com.dnassuncao.pokedex.bottomnav.currentRoute

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {

    val shouldShowBottomNavigation = when (currentRoute(navController)) {
        Screens.Search.route,
        Screens.Region.route,
        Screens.Favorite.route,
        Screens.Profile.route,
        -> true
        else -> false
    }

    Scaffold(
        bottomBar = {
            if (shouldShowBottomNavigation) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            NavigationGraph(navController = navController)
        }
    }
}