package br.com.mywishkart.ui.screen.home

import androidx.lifecycle.ViewModel
import br.com.mywishkart.repository.AppRepository

class HomeViewModel() : ViewModel() {

    private val wishRepository = AppRepository()

    val categoryList = wishRepository.categoryList

}