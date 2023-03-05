package br.com.mywishkart.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mywishkart.ui.theme.MyWishKartTheme

@Composable
fun EditItem(
    wish: String,
    value: String,
    buttonText: String,
    onWishChange: (String) -> Unit,
    onValueChange: (String) -> Unit
) {

    val localFocusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        Text(
            modifier = Modifier,
            text = "Wish",
            fontSize = 16.sp,
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = wish,
            onValueChange = { onWishChange(it) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onAny = { localFocusManager.clearFocus() }),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "R$",
            fontSize = 16.sp,
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = { onValueChange(it) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onAny = { localFocusManager.clearFocus() }),
            singleLine = true
        )
        Button(
            modifier = Modifier
                .padding(vertical = 30.dp)
                .fillMaxWidth(),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = buttonText
            )
        }
    }
}

@Preview
@Composable
fun EditItemPreview() {
    MyWishKartTheme {
        EditItem(
            wish = "Frango",
            value = "20.00",
            buttonText = "Criar",
            onWishChange = {},
        ) {

        }
    }
}