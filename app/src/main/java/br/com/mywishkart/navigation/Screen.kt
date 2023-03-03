package br.com.mywishkart.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
}