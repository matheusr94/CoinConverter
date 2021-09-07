package matheusrodrigues.androidapps.coinconverter.domain.di

import matheusrodrigues.androidapps.coinconverter.domain.GetExchangeValueUseCase
import matheusrodrigues.androidapps.coinconverter.domain.ListExchangeUseCase
import matheusrodrigues.androidapps.coinconverter.domain.SaveExchangeUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModules())
    }

    private fun useCaseModules(): Module {
        return module {
            factory { ListExchangeUseCase(get()) }
            factory { SaveExchangeUseCase(get()) }
            factory { GetExchangeValueUseCase(get()) }
        }
    }
}