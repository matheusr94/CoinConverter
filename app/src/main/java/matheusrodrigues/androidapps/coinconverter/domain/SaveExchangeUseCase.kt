package matheusrodrigues.androidapps.coinconverter.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import matheusrodrigues.androidapps.coinconverter.core.UseCase
import matheusrodrigues.androidapps.coinconverter.data.model.ExchangeResponseValue
import matheusrodrigues.androidapps.coinconverter.data.repository.CoinRepository

class SaveExchangeUseCase(
    private val repository: CoinRepository
) : UseCase.NoSource<ExchangeResponseValue>() {

    override suspend fun execute(param: ExchangeResponseValue): Flow<Unit> {
        return flow {
            repository.save(param)
            emit(Unit)
        }
    }
}