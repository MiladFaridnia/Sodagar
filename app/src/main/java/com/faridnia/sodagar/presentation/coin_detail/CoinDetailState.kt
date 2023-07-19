package com.faridnia.sodagar.presentation.coin_detail

import com.faridnia.sodagar.domain.model.coin_detail.CoinDetail

class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)