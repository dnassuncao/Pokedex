package br.com.dnassuncao.pokedex.features.detail.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokedex.R
import br.com.dnassuncao.pokedex.core.PokemonCategory
import br.com.dnassuncao.pokedex.features.detail.domain.model.PokemonDetail
import br.com.dnassuncao.pokedex.features.detail.presentation.components.Characteristic
import br.com.dnassuncao.pokedex.features.detail.presentation.components.PokeDetailData
import br.com.dnassuncao.pokedex.features.detail.presentation.components.PokeDetailHeader
import br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel.PokemonDetailUiState
import br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel.PokemonDetailUserEvent
import br.com.dnassuncao.pokedex.ui.common.UiStatus
import br.com.dnassuncao.pokemonapp.data.mapper.getRandomCategory

@Composable
fun PokemonDetailContent(
    uiState: PokemonDetailUiState,
    onUiEvent: (event: PokemonDetailUserEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (val status = uiState.status) {
            UiStatus.Loading -> {
                // TODO: Show loading state
            }

            is UiStatus.Failed -> {
                // TODO: Show error state
            }

            UiStatus.Success -> {
                uiState.pokemon?.let {
                    PokemonDetail(
                        pokemon = it,
                        onUiEvent = onUiEvent
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonDetail(
    pokemon: PokemonDetail,
    onUiEvent: (event: PokemonDetailUserEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)

        ) {

            PokeDetailHeader(
                image = pokemon.image,
                category = pokemon.category
            )

            PokeDetailData(
                name = pokemon.name,
                number = pokemon.id.toString()
            )

            PokemonCharacteristicSection(
                pokemon = pokemon
            )
        }
    }
}

@Composable
fun PokemonCharacteristicSection(
    pokemon: PokemonDetail,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxSize()
    ) {
        Characteristic(
            icon = R.drawable.ic_weight,
            name = "Weight",
            value = "${pokemon.weight?.div(100)} kg",
            modifier = Modifier
                .weight(0.5f)
        )
        Characteristic(
            icon = R.drawable.ic_height,
            name = "Height",
            value = "${pokemon.height?.div(100)} m",
            modifier = Modifier
                .weight(0.5f)
        )
    }
}

@Preview
@Composable
private fun PokemonContentPreview() {
    PokemonDetailContent(
        uiState = PokemonDetailUiState(
            status = UiStatus.Success,
            pokemon = PokemonDetail(
                id = 1,
                name = "Overgrow",
                image = "IMG",
                experience = 10,
                weight = 120,
                height = 230,
                category = getRandomCategory()
            )
        )
    ) {}
}