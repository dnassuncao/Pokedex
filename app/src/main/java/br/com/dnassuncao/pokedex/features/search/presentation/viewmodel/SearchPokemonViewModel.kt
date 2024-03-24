package br.com.dnassuncao.pokedex.features.search.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.dnassuncao.pokedex.features.search.domain.usecase.SearchPokemonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchPokemonViewModel(
    private val searchPokemonUseCase: SearchPokemonUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchPokemonState())
    val uiState: StateFlow<SearchPokemonState> = _uiState.asStateFlow()

    fun onUserEvent(event: SearchPokemonUserEvent) {
        when (event) {
            is SearchPokemonUserEvent.OnItemClick -> handleClickedOnPokemon(event = event)
            is SearchPokemonUserEvent.OnSearchPokemon -> handleOnSearch(event = event)
        }
    }

    private fun handleClickedOnPokemon(event: SearchPokemonUserEvent.OnItemClick) {
        viewModelScope.launch {
            // Navigate to Pokemon details
        }
    }

    private fun handleOnSearch(event: SearchPokemonUserEvent.OnSearchPokemon) {
        val pokemons = searchPokemonUseCase.invoke()
            .cachedIn(viewModelScope)

        _uiState.update { currentState ->
            currentState.copy(
                pokemons = pokemons
            )
        }
    }

}