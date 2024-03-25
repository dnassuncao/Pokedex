package br.com.dnassuncao.pokedex.features.search.presentation.viewmodel

import br.com.dnassuncao.pokedex.MainDispatcherRule
import br.com.dnassuncao.pokedex.features.search.domain.usecase.SearchPokemonUseCase
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Rule

class SearchPokemonViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: SearchPokemonViewModel

    @MockK
    private lateinit var useCase: SearchPokemonUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = SearchPokemonViewModel(searchPokemonUseCase = useCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

}