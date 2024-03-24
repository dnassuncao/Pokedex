package br.com.dnassuncao.pokedex.features.search.presentation.viewmodel

import androidx.paging.PagingData
import br.com.dnassuncao.pokedex.features.search.domain.model.PokemonItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class SearchPokemonState(
    val pokemons: Flow<PagingData<PokemonItem>> = emptyFlow()
)
