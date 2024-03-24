package br.com.dnassuncao.pokedex.features.search.data.mapper

import br.com.dnassuncao.pokedex.core.PokemonCategory
import br.com.dnassuncao.pokedex.features.search.data.model.PokemonResult
import br.com.dnassuncao.pokedex.features.search.domain.model.PokemonItem
import java.util.ServiceLoader




fun PokemonResult.toDomain(): PokemonItem {
    return PokemonItem(
        id = this.url.urlToId(),
        name = this.name,
        image = this.url.urlToImage(),
        category = getRandomCategory()
    )
}

//TODO: Create a BFF to list pokemons with categories
fun getRandomCategory() = PokemonCategory.values.random()

fun String.urlToImage(): String {
    val number = urlToId()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
}

fun String.urlToId(): Int {
    val number = if (this.endsWith("/")) {
        this.dropLast(1).takeLastWhile { it.isDigit() }
    } else {
        this.takeLastWhile { it.isDigit() }
    }

    return number.toInt()
}