package br.com.dnassuncao.pokedex.features.search.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokedex.R
import br.com.dnassuncao.pokedex.core.PokemonCategory

@Composable
fun PokeImageView(
    image: Int,
    category: PokemonCategory,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(
                topStart = 12.dp,
                bottomStart = 12.dp
            ))
            .background(category.color)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ) {
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = category.icon),
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.Center),
                contentDescription = ""
            )
            Image(
                painter = painterResource(id = image),
                modifier = Modifier
                    .size(35.dp)
                    .align(Alignment.Center),
                contentDescription = ""
            )
        }
    }
}

@Preview
@Composable
private fun PokeImageViewGrassPreview() {
    PokeImageView(
        image = R.drawable.bulbasaur,
        category = PokemonCategory.Grass
    )
}

@Preview
@Composable
private fun PokeImageViewWaterPreview() {
    PokeImageView(
        image = R.drawable.wartortle,
        category = PokemonCategory.Water
    )
}

@Preview
@Composable
private fun PokeImageViewFirePreview() {
    PokeImageView(
        image = R.drawable.charizard,
        category = PokemonCategory.Fire
    )
}