package br.com.dnassuncao.pokedex.features.detail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokedex.R
import br.com.dnassuncao.pokedex.core.PokemonCategory
import br.com.dnassuncao.pokedex.ui.theme.ColorGrass
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PokeDetailHeader(
    image: String,
    category: PokemonCategory,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .height(180.dp)
    ) {
        Column(
            modifier = modifier
                .clip(
                    shape = RoundedCornerShape(
                        bottomEnd = 100.dp,
                        bottomStart = 100.dp
                    )
                )
                .fillMaxWidth()
                .height(140.dp)
                .background(category.color)
                .align(Alignment.TopCenter),
            ){}
            AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.BottomCenter),
            contentDescription = ""
            )
    }
}

@Preview
@Composable
private fun PokeImageViewFirePreview() {
    PokeDetailHeader(
        image = "",
        category = PokemonCategory.Grass
    )
}