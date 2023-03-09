package br.com.mywishkart.di

import br.com.mywishkart.ui.screen.create.CreateItemViewModel
import br.com.mywishkart.ui.screen.home.HomeViewModel
import br.com.mywishkart.ui.screen.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule =module {

}

val SplashModule = module {
    viewModel { SplashViewModel() }
}

val HomeModule = module {
    viewModel { HomeViewModel() }
}

val CreateItemModule = module {
    viewModel { CreateItemViewModel() }
}