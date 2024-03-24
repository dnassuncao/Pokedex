package br.com.dnassuncao.pokedex.features.search.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.dnassuncao.pokedex.features.search.data.PokemonSearchApi
import br.com.dnassuncao.pokedex.features.search.data.mapper.toDomain
import br.com.dnassuncao.pokedex.features.search.domain.model.PokemonItem

class PokemonPagingDataSource(
    private val pokemonSearchApi: PokemonSearchApi
) : PagingSource<Int, PokemonItem>() {

    override fun getRefreshKey(state: PagingState<Int, PokemonItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonItem> {
        return try {
            val nextPageNumber = params.key ?: 0
            val response = pokemonSearchApi.searchPokemons(
                limit = PAGE_SIZE,
                offset = nextPageNumber
            )
            LoadResult.Page(
                data =  response.results.map { pokemonResult -> pokemonResult.toDomain() },
                prevKey = null,
                nextKey = nextPageNumber + PAGE_SIZE
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}