package br.com.dnassuncao.pokedex.features.search.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.dnassuncao.pokedex.features.search.data.PokemonSearchApi
import br.com.dnassuncao.pokedex.features.search.data.remote.PokemonPagingDataSource
import br.com.dnassuncao.pokedex.features.search.domain.model.PokemonItem
import br.com.dnassuncao.pokedex.features.search.domain.repository.SearchPokemonRepository
import kotlinx.coroutines.flow.Flow

class SearchPokemonRepositoryImpl(
    private val pokemonSearchApi: PokemonSearchApi
): SearchPokemonRepository {
    override fun searchPokemon(pagingConfig: PagingConfig): Flow<PagingData<PokemonItem>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                PokemonPagingDataSource(pokemonSearchApi)
            }
        ).flow
    }
}