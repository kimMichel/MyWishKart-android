package br.com.mywishkart.repository

import br.com.mywishkart.models.CategoryItem
import br.com.mywishkart.models.WishItem
import kotlinx.coroutines.flow.MutableStateFlow

class AppRepository {

    val categoryList: MutableStateFlow<List<CategoryItem>> = MutableStateFlow(
        listOf(
            CategoryItem(
                categoryTitle = "Familia",
                items = listOf(
                    WishItem(
                        title = "Frango",
                        date = "01/03/2023",
                        value = 200.00
                    ),
                    WishItem(
                        title = "Frango",
                        date = "01/03/2023",
                        value = 200.00
                    ),
                    WishItem(
                        title = "Frango",
                        date = "01/03/2023",
                        value = 200.00
                    ),
                    WishItem(
                        title = "Frango",
                        date = "01/03/2023",
                        value = 200.00
                    ),
                    WishItem(
                        title = "Frango",
                        date = "01/03/2023",
                        value = 200.00
                    ),
                )
            ),
            CategoryItem(
                categoryTitle = "Conta",
                items = listOf()
            ),
            CategoryItem(
                categoryTitle = "Goals",
                items = listOf(
                    WishItem(
                        title = "Frango",
                        date = "01/03/2023",
                        value = 200.00
                    ),
                    WishItem(
                        title = "Frango",
                        date = "01/03/2023",
                        value = 200.00
                    ),
                    WishItem(
                        title = "Frango",
                        date = "01/03/2023",
                        value = 200.00
                    ),
                    WishItem(
                        title = "Frango",
                        date = "01/03/2023",
                        value = 200.00
                    ),
                    WishItem(
                        title = "Frango",
                        date = "01/03/2023",
                        value = 200.00
                    ),
                )
            )
        )
    )
}