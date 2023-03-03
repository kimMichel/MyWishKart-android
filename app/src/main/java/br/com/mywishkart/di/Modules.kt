package br.com.mywishkart.di

import br.com.mywishkart.ui.screen.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule =module {

}

val SplashModule = module {
    viewModel { SplashViewModel() }
}