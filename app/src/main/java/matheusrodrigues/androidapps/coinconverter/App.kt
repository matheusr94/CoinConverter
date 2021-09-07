package matheusrodrigues.androidapps.coinconverter

import android.app.Application
import matheusrodrigues.androidapps.coinconverter.data.di.DataModules
import matheusrodrigues.androidapps.coinconverter.domain.di.DomainModule
import matheusrodrigues.androidapps.coinconverter.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModules.load()
        DomainModule.load()
        PresentationModule.load()
    }
}