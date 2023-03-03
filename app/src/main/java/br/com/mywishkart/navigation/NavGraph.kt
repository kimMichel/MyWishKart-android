package br.com.mywishkart.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import br.com.mywishkart.ui.screen.create.CreateScreen
import br.com.mywishkart.ui.screen.home.HomeScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    AnimatedNavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navHostController)
        }
        composable(
            route = "${Screen.Create.route}/{categoryTitle}",
            arguments = listOf(navArgument("categoryTitle") { type = NavType.StringType })
        ) {backStackEntry ->
            backStackEntry.arguments?.getString("categoryTitle")?.let { it -> CreateScreen(it) }
        }
    }
}