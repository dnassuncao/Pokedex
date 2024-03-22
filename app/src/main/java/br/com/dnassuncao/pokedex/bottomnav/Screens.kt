sealed class Screens(val route : String) {
    object Home : Screens("home_route")
    object Region : Screens("region_route")
    object Favorite : Screens("favorite_route")
    object Profile : Screens("profile_route")
}