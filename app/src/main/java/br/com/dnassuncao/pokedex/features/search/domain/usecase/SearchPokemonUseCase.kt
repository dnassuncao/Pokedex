package br.com.dnassuncao.pokedex.features.search.domain.usecase

import androidx.paging.PagingData
import br.com.dnassuncao.pokedex.features.search.domain.model.PokemonItem
import kotlinx.coroutines.flow.Flow

interface SearchPokemonUseCase {
    operator fun invoke(): Flow<PagingData<PokemonItem>>
}