package br.com.mywishkart

import android.app.Application
import br.com.mywishkart.di.CreateItemModule
import br.com.mywishkart.di.HomeModule
import br.com.mywishkart.di.SplashModule
import br.com.mywishkart.di.appModule
import br.com.mywishkart.ui.screen.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        val appModules =listOf(
            appModule,
            SplashModule,
            HomeModule,
            CreateItemModule
        )
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(appModules)
        }
    }
}