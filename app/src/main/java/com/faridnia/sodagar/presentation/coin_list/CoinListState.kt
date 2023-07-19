package com.faridnia.sodagar.presentation.coin_list

import com.faridnia.sodagar.domain.model.coin_list.Coin

class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<Coin> = emptyList(),
    val error: String = ""
)