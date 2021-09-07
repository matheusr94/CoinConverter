package matheusrodrigues.androidapps.coinconverter.data.repository

import android.os.RemoteException
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import matheusrodrigues.androidapps.coinconverter.data.model.ErrorResponse
import matheusrodrigues.androidapps.coinconverter.data.model.ExchangeResponseValue
import matheusrodrigues.androidapps.coinconverter.data.services.AwesomeService
import matheusrodrigues.androidapps.coinconverter.database.AppDatabase
import retrofit2.HttpException

class CoinRepositoryImpl(
    appDatabase: AppDatabase,
    private val service: AwesomeService
) : CoinRepository {

    private val dao = appDatabase.exchangeDao()

    override suspend fun getExchangeValue(coins: String) = flow {
        try {
            val exchangeValue = service.exchangeValue(coins)
            val exchange = exchangeValue.values.first()
            emit(exchange)
        } catch (e: HttpException) {
            // {"status":404,"code":"CoinNotExists","message":"moeda nao encontrada USD-USD"}
            val json = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(json, ErrorResponse::class.java)
            throw matheusrodrigues.androidapps.coinconverter.core.exceptions.RemoteException(errorResponse.message)
        }
    }

    override suspend fun save(exchange: ExchangeResponseValue) {
        dao.save(exchange)
    }

    override fun list(): Flow<List<ExchangeResponseValue>> {
        return dao.findAll()
    }
}