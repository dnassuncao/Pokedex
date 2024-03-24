package br.com.dnassuncao.pokedex.features.search.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.dnassuncao.pokedex.features.search.domain.model.PokemonItem
import br.com.dnassuncao.pokedex.features.search.domain.repository.SearchPokemonRepository
import kotlinx.coroutines.flow.Flow

class SearchPokemonUseCaseImpl (
    private val searchPokemonRepository: SearchPokemonRepository
) : SearchPokemonUseCase {
    override fun invoke(): Flow<PagingData<PokemonItem>> {
        return searchPokemonRepository.searchPokemon(
            PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
            )
        )
    }
}