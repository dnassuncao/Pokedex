package br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel

import br.com.dnassuncao.pokedex.MainDispatcherRule
import br.com.dnassuncao.pokedex.features.detail.data.model.PokemonDetailResponse
import br.com.dnassuncao.pokedex.features.detail.domain.usecase.FetchPokemonUseCase
import br.com.dnassuncao.pokedex.ui.common.UiStatus
import br.com.dnassuncao.pokemonapp.data.mapper.toDomain
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonDetailViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: PokemonDetailViewModel

    @MockK
    private lateinit var useCase: FetchPokemonUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = PokemonDetailViewModel(fetchPokemonUseCase = useCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `on init screen event, when FetchPokemonUseCase successful should return a pokemon`() =
        runTest {

            // Given
            val pokemon = PokemonDetailResponse(
                id = 1,
                experience = 12,
                weight = 5,
                height = 10,
                name = "bulbasaur"
            ).toDomain()

            coEvery { useCase("1") } returns flow {
                emit(
                    pokemon
                )
            }

            val expectedSuccess =
                PokemonDetailUiState(
                    status = UiStatus.Success,
                    pokemon = pokemon
                )

            // When
            viewModel.onUserEvent(PokemonDetailUserEvent.OnInitScreen("1"))

            // Then
            advanceUntilIdle()

            assertThat(viewModel.uiState.first()).isEqualTo(expectedSuccess)
        }

}

