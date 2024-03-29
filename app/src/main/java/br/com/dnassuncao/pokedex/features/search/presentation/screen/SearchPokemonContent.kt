package br.com.dnassuncao.pokedex.features.search.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import br.com.dnassuncao.pokedex.R
import br.com.dnassuncao.pokedex.features.search.domain.model.PokemonItem
import br.com.dnassuncao.pokedex.features.search.presentation.components.PokeItem
import br.com.dnassuncao.pokedex.features.search.presentation.viewmodel.SearchPokemonUserEvent
import br.com.dnassuncao.pokedex.ui.components.PokeLoading
import br.com.dnassuncao.pokedex.ui.components.ErrorAlert
import kotlinx.coroutines.flow.Flow

@Composable
fun SearchPokemonContent(
    pokemonPager: Flow<PagingData<PokemonItem>>,
    onUiEvent: (event: SearchPokemonUserEvent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val pokemons = pokemonPager.collectAsLazyPagingItems()

        LazyColumn {
            items(pokemons.itemCount){ item ->
                val poke = pokemons[item]
                poke?.let {
                    Column(Modifier.padding(10.dp)) {
                        PokeItem(
                            number = poke.id,
                            name = poke.name,
                            image = poke.image,
                            category = poke.category,
                        ) {
                            onUiEvent.invoke(SearchPokemonUserEvent.OnItemClick(pokemonId = it.id))
                        }
                    }
                }
            }
            pokemons.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item {
                            PokeLoading(
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item {
                            PokeLoading(
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                    loadState.append is LoadState.Error -> {
                        item {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                ErrorAlert(
                                    message = stringResource(R.string.error_load_data),
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}