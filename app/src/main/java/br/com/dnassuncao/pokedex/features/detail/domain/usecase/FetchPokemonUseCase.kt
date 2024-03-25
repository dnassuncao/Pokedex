package br.com.dnassuncao.pokedex.features.detail.domain.usecase

import br.com.dnassuncao.pokedex.features.detail.domain.model.PokemonDetail
import kotlinx.coroutines.flow.Flow

interface FetchPokemonUseCase {
    suspend operator fun invoke(pokemonId: String): Flow<PokemonDetail>
}