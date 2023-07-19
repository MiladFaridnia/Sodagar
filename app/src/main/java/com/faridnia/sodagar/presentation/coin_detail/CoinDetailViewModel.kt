package com.faridnia.sodagar.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faridnia.sodagar.domain.use_case.get_coin_list.GetCoinDetailUseCase
import com.faridnia.sodagar.util.Constants
import com.faridnia.sodagar.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())

    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let {
            getCoinDetail(it)
        }
    }

    private fun getCoinDetail(coinId: String) {
        getCoinDetailUseCase(coinId = coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coinDetail = result.data)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "Unexpected Error")
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}