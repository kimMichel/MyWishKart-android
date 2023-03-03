package br.com.mywishkart.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mywishkart.ui.theme.MyWishKartTheme
import br.com.mywishkart.R
import br.com.mywishkart.models.CategoryItem
import br.com.mywishkart.models.WishItem

@Composable
fun HomeItem(
    category: CategoryItem,
    navigateTo: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier,
                    text = category.categoryTitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Button(onClick = { navigateTo() }) {
                    Text(text = "Add")
                }
            }
            category.items.forEach { ItemPerCategory(item = it) }
        }

    }
}

@Composable
fun ItemPerCategory(item: WishItem) {

    val checkedState = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    modifier = Modifier,
                    text = item.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp),
                    text = item.date,
                    fontSize = 8.sp
                )
            }
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "R$",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .padding(end = 10.dp),
                    text = item.value.toString().replace(".", ","),
                    fontWeight = FontWeight.Bold
                )
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it }
                )
                Image(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    painter = painterResource(id = R.drawable.ic_edit),
                    contentDescription = "Edit Item Button"
                )
                Image(
                    modifier = Modifier
                        .padding(end = 10.dp),
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Delete Item Button"
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeItemPreview() {
    MyWishKartTheme() {
        HomeItem(
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
            )
        ) {

        }
    }
}

@Preview
@Composable
fun ItemPerCategoryPreview() {
    MyWishKartTheme {
        ItemPerCategory(
            WishItem(
                title = "Frango",
                date = "01/03/2023",
                value = 200.00
            )
        )
    }
}