package br.com.dnassuncao.pokedex.features.detail.domain.repository

import br.com.dnassuncao.pokedex.features.detail.domain.model.PokemonDetail
import kotlinx.coroutines.flow.Flow

interface PokemonDetailRepository {

    suspend fun fetchPokemonDetail(pokemonId: String): Flow<PokemonDetail>
}