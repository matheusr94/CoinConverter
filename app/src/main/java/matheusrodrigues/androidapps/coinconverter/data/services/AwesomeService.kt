package matheusrodrigues.androidapps.coinconverter.data.services

import retrofit2.http.GET
import retrofit2.http.Path

interface AwesomeService {

    @GET("/jason/last/{coins}")
    suspend fun exchangeValue(@Path("coins") coins: String)
}