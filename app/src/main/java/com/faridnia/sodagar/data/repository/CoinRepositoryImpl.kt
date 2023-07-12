package com.faridnia.sodagar.data.repository

import com.faridnia.sodagar.data.remote.CoinPaprikaApi
import com.faridnia.sodagar.data.remote.dto.coil_list.CoinDto
import com.faridnia.sodagar.data.remote.dto.coin_detail.CoinDetailDto
import com.faridnia.sodagar.domain.repository.CoinRepository
import javax.inject.Inject


class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoinList(): List<CoinDto> {
        return api.getCoinList()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}