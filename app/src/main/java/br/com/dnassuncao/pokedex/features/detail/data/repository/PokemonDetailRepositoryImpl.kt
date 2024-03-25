package br.com.dnassuncao.pokedex.features.detail.data.repository

import br.com.dnassuncao.pokedex.features.detail.data.PokemonDetailApi
import br.com.dnassuncao.pokedex.features.detail.domain.model.PokemonDetail
import br.com.dnassuncao.pokedex.features.detail.domain.repository.PokemonDetailRepository
import br.com.dnassuncao.pokemonapp.data.mapper.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonDetailRepositoryImpl(
    private val pokemonDetailApi: PokemonDetailApi
) : PokemonDetailRepository {

    override suspend fun fetchPokemonDetail(pokemonId: String): Flow<PokemonDetail> = flow {
        emit(
            pokemonDetailApi.fetchPokemonDetails(pokemonId).toDomain()
        )
    }
}
