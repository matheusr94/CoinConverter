package matheusrodrigues.androidapps.coinconverter.domain

import kotlinx.coroutines.flow.Flow
import matheusrodrigues.androidapps.coinconverter.core.UseCase
import matheusrodrigues.androidapps.coinconverter.data.model.ExchangeResponseValue
import matheusrodrigues.androidapps.coinconverter.data.repository.CoinRepository

class ListExchangeUseCase(
    private val repository: CoinRepository
) : UseCase.NoParam<List<ExchangeResponseValue>>() {

    override suspend fun execute(): Flow<List<ExchangeResponseValue>> {
        return repository.list()
    }
}