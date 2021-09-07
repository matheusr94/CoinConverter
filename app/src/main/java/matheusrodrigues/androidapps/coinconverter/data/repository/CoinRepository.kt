package matheusrodrigues.androidapps.coinconverter.data.repository

import kotlinx.coroutines.flow.Flow
import matheusrodrigues.androidapps.coinconverter.data.model.ExchangeResponseValue

interface CoinRepository {
    suspend fun getExchangeValue(coins: String): Flow<ExchangeResponseValue>

    suspend fun save(exchange: ExchangeResponseValue)
    fun list(): Flow<List<ExchangeResponseValue>>
}