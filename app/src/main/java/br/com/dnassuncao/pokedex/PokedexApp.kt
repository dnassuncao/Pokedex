package br.com.dnassuncao.pokedex

import android.app.Application
import br.com.dnassuncao.pokedex.core.network.networkModule
import br.com.dnassuncao.pokedex.features.search.di.searchModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PokedexApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(androidContext = this@PokedexApp)
            modules(
                arrayListOf(
                    networkModule,
                    searchModule
                )
            )
        }
    }
}