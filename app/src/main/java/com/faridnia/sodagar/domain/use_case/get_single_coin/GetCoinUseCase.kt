package com.faridnia.sodagar.domain.use_case.get_single_coin

import com.faridnia.sodagar.data.remote.dto.coil_list.toCoin
import com.faridnia.sodagar.domain.model.coin_list.Coin
import com.faridnia.sodagar.domain.repository.CoinRepository
import com.faridnia.sodagar.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {

            emit(Resource.Loading())
            val coins = repository.getCoinList().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {

            emit(Resource.Error(e.localizedMessage ?: "Error occurred"))

        } catch (e: IOException) {

            emit(
                Resource.Error(
                    e.localizedMessage ?: "Couldn't reach server. Check your internet connection"
                )
            )
        }
    }
}