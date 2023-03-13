package br.com.mywishkart.ui.screen.create

import androidx.lifecycle.ViewModel
import br.com.mywishkart.models.CategoryItem
import br.com.mywishkart.repository.AppRepository
import kotlinx.coroutines.flow.MutableStateFlow

class CreateItemViewModel() : ViewModel() {

    val wishRepository = AppRepository()

    val wishInputText = MutableStateFlow("")
    val wishValueInputText = MutableStateFlow("")

    fun onWishChange(value: String) {
        wishInputText.value = value
    }

    fun onWishValueChange(value: String) {
        wishValueInputText.value =  value
    }

    fun createItem(category: String) {

    }

}