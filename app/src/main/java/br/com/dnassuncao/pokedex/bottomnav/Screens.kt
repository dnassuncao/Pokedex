sealed class Screens(val route : String) {
    object Search : Screens("search_route")
    object Region : Screens("region_route")
    object Favorite : Screens("favorite_route")
    object Profile : Screens("profile_route")
}