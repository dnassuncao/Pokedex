package br.com.dnassuncao.pokedex.features.detail.data

import br.com.dnassuncao.pokedex.features.detail.data.model.PokemonDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonDetailApi {
    @GET("pokemon/{pokemon}")
    suspend fun fetchPokemonDetails(
        @Path("pokemon") pokemon: String,
    ): PokemonDetailResponse
}