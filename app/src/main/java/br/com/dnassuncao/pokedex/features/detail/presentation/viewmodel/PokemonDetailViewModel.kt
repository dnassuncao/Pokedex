package br.com.dnassuncao.pokedex.features.detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dnassuncao.pokedex.core.extensions.onError
import br.com.dnassuncao.pokedex.core.extensions.onSuccess
import br.com.dnassuncao.pokedex.features.detail.domain.usecase.FetchPokemonUseCase
import br.com.dnassuncao.pokedex.ui.common.UiStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val fetchPokemonUseCase: FetchPokemonUseCase
) : ViewModel() {

//    private val _navigationChannel = Channel<PokemonDetailNavigationRequest>()
//    val navigationRequest = _navigationChannel.receiveAsFlow()

    private val _uiState = MutableStateFlow(PokemonDetailUiState())
    val uiState: StateFlow<PokemonDetailUiState> = _uiState.asStateFlow()

    fun onUserEvent(event: PokemonDetailUserEvent) {
        when (event) {
            is PokemonDetailUserEvent.OnInitScreen -> handleOnInitScreenEvent(event)
        }
    }

    private fun handleOnInitScreenEvent(event: PokemonDetailUserEvent.OnInitScreen) {
        viewModelScope.launch {

            fetchPokemonUseCase(event.pokemonId)
                .onError {
                    _uiState.update { currentState ->
                        currentState.copy(
                            status = UiStatus.Failed(""),
                        )
                    }
                }.onSuccess {
                    _uiState.update { currentState ->
                        currentState.copy(
                            status = UiStatus.Success,
                            pokemon = it
                        )
                    }
                }
        }
    }
}