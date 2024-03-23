package br.com.dnassuncao.pokedex.features.search.presentation.components

import androidx.compose.foundation.background
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
import br.com.dnassuncao.pokedex.ui.theme.Title
import br.com.dnassuncao.pokedex.ui.theme.Typography

//TODO: Refactor when add viewmodel
data class Pokemon(
    val name: String,
    val number: String,
    val image: Int,
    val category: PokemonCategory
)

@Composable
fun PokeItem(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(pokemon.category.backgroundColor)
            .height(120.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .weight(1f)
        ) {
            Text(
                text = "N°${pokemon.number}",
                style = Typography.titleMedium,
                color = Title
            )
            Text(
                text = pokemon.name,
                style = Typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            PokeType(
                name = pokemon.name,
                category = pokemon.category
            )
        }

        PokeImageView(
            image = pokemon.image,
            category = pokemon.category,
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
        pokemon = Pokemon(
            number = "001",
            name = "Bulbasaur",
            image = R.drawable.bulbasaur,
            category = PokemonCategory.Grass
        )
    )
}

@Preview
@Composable
private fun PokeItemWaterPreview() {
    PokeItem(
        pokemon = Pokemon(
            number = "022",
            name = "Wartortle",
            image = R.drawable.wartortle,
            category = PokemonCategory.Water
        )
    )
}

@Preview
@Composable
private fun PokeItemFirePreview() {
    PokeItem(
        pokemon = Pokemon(
            number = "010",
            name = "Charizard",
            image = R.drawable.charizard,
            category = PokemonCategory.Fire
        )
    )
}