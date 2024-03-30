package br.com.dnassuncao.pokedex.bottomnav

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    NavigationBar {
        BottomNavigationItem().bottomNavigationItems().forEachIndexed {index, navigationItem ->
            val selected = currentRoute(navController) == navigationItem.route
            NavigationBarItem(
                selected = selected,
                alwaysShowLabel = false,
                label = {
                    Text(navigationItem.title)
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            if (selected) navigationItem.iconSelected else navigationItem.icon
                        ),
                        contentDescription = navigationItem.title
                    )
                },
                onClick = {
                    navController.navigate(navigationItem.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(navController = rememberNavController())
}