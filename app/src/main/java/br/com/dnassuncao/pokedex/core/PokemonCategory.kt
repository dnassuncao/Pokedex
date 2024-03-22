package br.com.dnassuncao.pokedex.core

import androidx.compose.ui.graphics.Color
import br.com.dnassuncao.pokedex.R
import br.com.dnassuncao.pokedex.ui.theme.ColorFire
import br.com.dnassuncao.pokedex.ui.theme.ColorGrass
import br.com.dnassuncao.pokedex.ui.theme.ColorWater

sealed class PokemonCategory(
    val icon : Int,
    val color : Color
) {
    data object Water : PokemonCategory(
        icon = R.drawable.ic_category_water,
        color = ColorWater
    )

    data object Grass : PokemonCategory(
        icon = R.drawable.ic_category_grass,
        color = ColorGrass
    )

    data object Fire : PokemonCategory(
        icon = R.drawable.ic_category_fire,
        color = ColorFire
    )
}