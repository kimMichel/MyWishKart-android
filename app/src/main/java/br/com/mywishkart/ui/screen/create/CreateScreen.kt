package br.com.mywishkart.ui.screen.create

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mywishkart.ui.components.EditItem
import br.com.mywishkart.ui.theme.MyWishKartTheme

@Composable
fun CreateScreen(
    args: String
) {
    Box(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize()
    ) {
        Column {
            Text(
                modifier = Modifier,
                text = args,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            EditItem(
                wish = "TODO",
                value = "200.00",
                buttonText = "Create",
                onWishChange = { }
            ) {

            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CreateScreenPreview() {
    MyWishKartTheme {
        CreateScreen("Category")
    }
}