package br.com.dnassuncao.pokedex.features.search.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.dnassuncao.pokedex.features.search.domain.model.PokemonItem
import kotlinx.coroutines.flow.Flow

interface SearchPokemonRepository {

    fun searchPokemon(pagingConfig: PagingConfig): Flow<PagingData<PokemonItem>>
}