package br.com.dnassuncao.pokedex.features.search.data

import br.com.dnassuncao.pokedex.features.search.data.model.PokemonResponseList
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonSearchApi {
    @GET("pokemon")
    suspend fun searchPokemons(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): PokemonResponseList
}