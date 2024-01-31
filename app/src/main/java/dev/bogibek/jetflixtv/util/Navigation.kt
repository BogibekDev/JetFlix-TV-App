package dev.bogibek.jetflixtv.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.bogibek.jetflixtv.ui.screen.HomeScreen
import dev.bogibek.jetflixtv.ui.screen.MovieScreen


sealed class Screens(val route: String) {

    //add here Screens' route
    data object Home : Screens(route = "home")
    data object Movie : Screens(route = "movie")

}


@Composable
fun MyNavGraph(navHostController: NavHostController) {

    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navHostController, startDestination = Screens.Home.route
    ) {

        //add Screens
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navHostController, sharedViewModel = sharedViewModel)
        }

        composable(route = Screens.Movie.route) {
            MovieScreen(navHostController = navHostController, sharedViewModel = sharedViewModel)
        }


    }
}

class SharedViewModel : ViewModel() {
    var data by mutableStateOf<Any?>(null)
}



