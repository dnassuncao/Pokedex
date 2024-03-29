sealed class Screens(val route : String) {
    data object Search : Screens("search_route")
    data object Region : Screens("region_route")
    data object Favorite : Screens("favorite_route")
    data object Profile : Screens("profile_route")
    data object Detail : Screens("details/{pokemonId}")
}