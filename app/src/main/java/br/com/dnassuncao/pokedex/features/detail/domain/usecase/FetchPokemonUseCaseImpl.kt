package br.com.dnassuncao.pokedex.features.detail.domain.usecase

import br.com.dnassuncao.pokedex.features.detail.domain.model.PokemonDetail
import br.com.dnassuncao.pokedex.features.detail.domain.repository.PokemonDetailRepository
import kotlinx.coroutines.flow.Flow

class FetchPokemonUseCaseImpl(
    private val pokemonDetailRepository: PokemonDetailRepository
) : FetchPokemonUseCase {
    override suspend fun invoke(pokemonId: String): Flow<PokemonDetail> =
        pokemonDetailRepository.fetchPokemonDetail(pokemonId)
}
