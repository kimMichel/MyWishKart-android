package br.com.mywishkart.ui.screen.create

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CreateItemViewModel() : ViewModel() {

    val wishInputText = MutableStateFlow("")
    val wishValueInputText = MutableStateFlow("")

    fun onWishChange(value: String) {
        wishInputText.value = value
    }

    fun onWishValueChange(value: String) {
        wishValueInputText.value =  value
    }

}