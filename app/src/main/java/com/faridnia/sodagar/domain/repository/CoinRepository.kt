package com.faridnia.sodagar.domain.repository

import com.faridnia.sodagar.data.remote.dto.coil_list.CoinDto
import com.faridnia.sodagar.data.remote.dto.coin_detail.CoinDetailDto

interface CoinRepository {

    suspend fun getCoinList(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}