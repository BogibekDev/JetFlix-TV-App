package dev.bogibek.jetflixtv.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import dev.bogibek.jetflixtv.model.Movie
import dev.bogibek.jetflixtv.ui.view.MyVideoPlayer
import dev.bogibek.jetflixtv.util.SharedViewModel

@Composable
fun MovieScreen(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    val movie = sharedViewModel.data as Movie?

    MyVideoPlayer(
        modifier = Modifier
            .fillMaxSize(),
        videoUrl = movie?.videoUrl ?: ""
    )
}