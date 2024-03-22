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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
        Box (
            modifier = Modifier.padding(it)
        ){
            NavigationGraph(navController = navController)
        }
    }
}