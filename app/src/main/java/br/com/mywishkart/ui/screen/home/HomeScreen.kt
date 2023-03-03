package br.com.mywishkart.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.mywishkart.models.CategoryItem
import br.com.mywishkart.models.WishItem
import br.com.mywishkart.navigation.Screen
import br.com.mywishkart.ui.components.HomeItem

@Composable
fun HomeScreen(
    navController: NavHostController
) {

    val categoryList = listOf(
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

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeContent(
            categoryList = categoryList,
            navController = navController
        )
    }
}

@Composable
fun HomeContent(
    categoryList: List<CategoryItem>,
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 4.dp)
    ) {
        items(categoryList.size) { i ->
            val category = categoryList[i]
            HomeItem(category = category) {
                navController.navigate("${Screen.Create.route}/${category.categoryTitle}")
            }
        }
    }
}

@Preview
@Composable
fun HomeContentPreview() {
    HomeContent(
        categoryList = listOf(
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
                items = listOf(
                )
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
        ),
        navController = rememberNavController()
    )
}
