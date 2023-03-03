package br.com.mywishkart.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Create : Screen("create_item_screen")
}