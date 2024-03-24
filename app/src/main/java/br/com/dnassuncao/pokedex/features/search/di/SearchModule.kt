package br.com.dnassuncao.pokedex.features.search.di

import br.com.dnassuncao.pokedex.features.search.data.PokemonSearchApi
import br.com.dnassuncao.pokedex.features.search.data.repository.SearchPokemonRepositoryImpl
import br.com.dnassuncao.pokedex.features.search.domain.repository.SearchPokemonRepository
import br.com.dnassuncao.pokedex.features.search.domain.usecase.SearchPokemonUseCase
import br.com.dnassuncao.pokedex.features.search.domain.usecase.SearchPokemonUseCaseImpl
import br.com.dnassuncao.pokedex.features.search.presentation.viewmodel.SearchPokemonViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val searchModule = module {

    factory {
        providePokemonSearchApi(get())
    }

    single<SearchPokemonUseCase> {
        SearchPokemonUseCaseImpl(
            searchPokemonRepository = get()
        )
    }

    single<SearchPokemonRepository> {
        SearchPokemonRepositoryImpl(get())
    }

    viewModel {
        SearchPokemonViewModel(get())
    }

}

fun providePokemonSearchApi(retrofit: Retrofit): PokemonSearchApi = retrofit.create(PokemonSearchApi::class.java)