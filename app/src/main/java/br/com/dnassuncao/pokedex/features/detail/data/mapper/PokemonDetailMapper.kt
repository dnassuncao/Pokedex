package br.com.dnassuncao.pokemonapp.data.mapper

import br.com.dnassuncao.pokedex.core.PokemonCategory
import br.com.dnassuncao.pokedex.features.detail.data.model.PokemonDetailResponse
import br.com.dnassuncao.pokedex.features.detail.domain.model.PokemonDetail

fun PokemonDetailResponse.toDomain(): PokemonDetail {
    return PokemonDetail(
        id = this.id,
        name = this.name,
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this.id}.png",
        experience = this.experience,
        weight = this.weight,
        height = this.height,
        category = getRandomCategory()
    )
}

//TODO: Create a BFF to list pokemons with categories
fun getRandomCategory() = PokemonCategory.values.random()