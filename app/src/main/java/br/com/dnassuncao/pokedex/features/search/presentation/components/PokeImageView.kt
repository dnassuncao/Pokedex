package br.com.dnassuncao.pokedex.features.search.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokedex.core.PokemonCategory
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PokeImageView(
    image: String,
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
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image)
                    .crossfade(true)
                    .build(),
                modifier = Modifier
                    .size(55.dp)
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
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/16.png",
        category = PokemonCategory.Grass
    )
}

@Preview
@Composable
private fun PokeImageViewWaterPreview() {
    PokeImageView(
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/16.png",
        category = PokemonCategory.Water
    )
}

@Preview
@Composable
private fun PokeImageViewFirePreview() {
    PokeImageView(
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/16.png",
        category = PokemonCategory.Fire
    )
}