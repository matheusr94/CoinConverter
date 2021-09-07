package matheusrodrigues.androidapps.coinconverter.domain

import kotlinx.coroutines.flow.Flow
import matheusrodrigues.androidapps.coinconverter.core.UseCase
import matheusrodrigues.androidapps.coinconverter.data.model.ExchangeResponseValue
import matheusrodrigues.androidapps.coinconverter.data.repository.CoinRepository

class GetExchangeValueUseCase(
    private val repository: CoinRepository
) : UseCase<String, ExchangeResponseValue>() {

    override suspend fun execute(param: String): Flow<ExchangeResponseValue> {
        return repository.getExchangeValue(param)
    }

}