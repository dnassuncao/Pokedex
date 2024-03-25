package br.com.dnassuncao.pokedex.features.detail.di

import br.com.dnassuncao.pokedex.features.detail.data.PokemonDetailApi
import br.com.dnassuncao.pokedex.features.detail.data.repository.PokemonDetailRepositoryImpl
import br.com.dnassuncao.pokedex.features.detail.domain.repository.PokemonDetailRepository
import br.com.dnassuncao.pokedex.features.detail.domain.usecase.FetchPokemonUseCase
import br.com.dnassuncao.pokedex.features.detail.domain.usecase.FetchPokemonUseCaseImpl
import br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel.PokemonDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val detailModule = module {

    factory {
        providePokemonDetailApi(get())
    }

    single<FetchPokemonUseCase> {
        FetchPokemonUseCaseImpl(
            pokemonDetailRepository = get()
        )
    }

    single<PokemonDetailRepository> {
        PokemonDetailRepositoryImpl(
            pokemonDetailApi = get()
        )
    }

    viewModel {
        PokemonDetailViewModel(
            fetchPokemonUseCase = get()
        )
    }

}

fun providePokemonDetailApi(retrofit: Retrofit): PokemonDetailApi =
    retrofit.create(PokemonDetailApi::class.java)