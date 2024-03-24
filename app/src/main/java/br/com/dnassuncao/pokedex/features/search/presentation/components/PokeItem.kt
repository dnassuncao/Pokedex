package br.com.dnassuncao.pokedex.features.search.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokedex.R
import br.com.dnassuncao.pokedex.core.PokemonCategory
import br.com.dnassuncao.pokedex.ui.theme.ColorGrass
import br.com.dnassuncao.pokedex.ui.theme.ColorGrassBackground
import br.com.dnassuncao.pokedex.ui.theme.Title
import br.com.dnassuncao.pokedex.ui.theme.Typography

@Composable
fun PokeItem(
    number: Int,
    name: String,
    image: String,
    category: PokemonCategory,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(category.backgroundColor)
            .height(120.dp)
            .fillMaxWidth()
            .clickable {
                onClick.invoke()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .weight(1f)
        ) {
            Text(
                text = "N°${number}",
                style = Typography.titleMedium,
                color = Title
            )
            Text(
                text = name,
                style = Typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            PokeType(
                category = category
            )
        }
        PokeImageView(
            image = image,
            category = category,
            modifier = Modifier
                .weight(0.5f)
                .fillMaxHeight()
        )
    }
}

@Preview
@Composable
private fun PokeItemGrassPreview() {
    PokeItem(
        number = 1,
        name = "Bulbasaur",
        image = "",
        category = PokemonCategory.Grass,
        onClick = {}
    )
}

@Preview
@Composable
private fun PokeItemWaterPreview() {
    PokeItem(
        number = 2,
        name = "Wartortle",
        image = "",
        category = PokemonCategory.Water,
        onClick = {}
    )
}

@Preview
@Composable
private fun PokeItemFirePreview() {
    PokeItem(
        number = 3,
        name = "Charizard",
        image = "",
        category = PokemonCategory.Fire,
        onClick = {}
    )
}