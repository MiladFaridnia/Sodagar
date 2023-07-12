package com.faridnia.sodagar.data.remote

import com.faridnia.sodagar.data.remote.dto.coil_list.CoinDto
import com.faridnia.sodagar.data.remote.dto.coin_detail.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoinList(): List<CoinDto>


    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

}