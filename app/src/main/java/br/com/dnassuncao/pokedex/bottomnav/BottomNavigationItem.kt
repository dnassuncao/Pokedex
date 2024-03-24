package br.com.dnassuncao.pokedex.bottomnav

import Screens
import br.com.dnassuncao.pokedex.R

data class BottomNavigationItem(
    val title: String = "",
    val icon: Int = 0,
    val iconSelected: Int = 0,
    val route: String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                title = "Pokedéx",
                icon = R.drawable.ic_bottom_bar_home,
                iconSelected = R.drawable.ic_bottom_bar_home_selected,
                route = Screens.Search.route
            ),
            BottomNavigationItem(
                title = "Regions",
                icon = R.drawable.ic_bottom_bar_region,
                iconSelected = R.drawable.ic_bottom_bar_region_selected,
                route = Screens.Region.route
            ),
            BottomNavigationItem(
                title = "Favorite",
                icon = R.drawable.ic_bottom_bar_favorite,
                iconSelected = R.drawable.ic_bottom_bar_favorite_selected,
                route = Screens.Favorite.route
            ),
            BottomNavigationItem(
                title = "Profile",
                icon = R.drawable.ic_bottom_bar_profile,
                iconSelected = R.drawable.ic_bottom_bar_profile_selected,
                route = Screens.Profile.route
            )
        )
    }
}