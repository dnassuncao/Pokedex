package br.com.dnassuncao.pokedex.core

import androidx.compose.ui.graphics.Color
import br.com.dnassuncao.pokedex.R
import br.com.dnassuncao.pokedex.ui.theme.ColorFire
import br.com.dnassuncao.pokedex.ui.theme.ColorFireBackground
import br.com.dnassuncao.pokedex.ui.theme.ColorGrass
import br.com.dnassuncao.pokedex.ui.theme.ColorGrassBackground
import br.com.dnassuncao.pokedex.ui.theme.ColorWater
import br.com.dnassuncao.pokedex.ui.theme.ColorWaterBackground

sealed class PokemonCategory(
    val icon: Int,
    val color: Color,
    val backgroundColor: Color,
) {
    data object Water : PokemonCategory(
        icon = R.drawable.ic_category_water,
        color = ColorWater,
        backgroundColor = ColorWaterBackground
    )

    data object Grass : PokemonCategory(
        icon = R.drawable.ic_category_grass,
        color = ColorGrass,
        backgroundColor = ColorGrassBackground
    )

    data object Fire : PokemonCategory(
        icon = R.drawable.ic_category_fire,
        color = ColorFire,
        backgroundColor = ColorFireBackground
    )

    companion object {
        val values: List<PokemonCategory> = listOf(
            Water,
            Grass,
            Fire
        )
    }
}