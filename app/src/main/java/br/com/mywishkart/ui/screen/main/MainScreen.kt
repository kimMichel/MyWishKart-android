package br.com.mywishkart.ui.screen.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import br.com.mywishkart.R
import br.com.mywishkart.navigation.Screen
import br.com.mywishkart.navigation.SetupNavGraph
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()
    val currentDestination = navController.currentBackStackEntry?.destination?.route
    var isAddFloatingButton by remember {
        mutableStateOf(
            checkAddFloatingButtonByDestination(
                currentDestination
            )
        )
    }

    Scaffold(
        scaffoldState = rememberScaffoldState(),
        floatingActionButton = {
            if (isAddFloatingButton) AddFloatingButton(navController = navController)
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            SetupNavGraph(navHostController = navController)
        }
    }
}

@Composable
fun AddFloatingButton(
    navController: NavHostController
) {
    FloatingActionButton(
        onClick = {
            navigateToScreen(Screen.Create, navController)
        }
    ) {
        Image(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.ic_cross),
            contentDescription = "Botao adicionar",
        )
    }
}

private fun navigateToScreen(screen: Screen, navController: NavHostController) {
    navController.navigate(screen.route) {
        popUpTo(navController.graph.findStartDestination().id)
        launchSingleTop = true
        restoreState = true
    }
}

fun checkAddFloatingButtonByDestination(route: String?): Boolean {
    return when (route) {
        Screen.Home.route -> true
        null -> true
        else -> true
    }
}