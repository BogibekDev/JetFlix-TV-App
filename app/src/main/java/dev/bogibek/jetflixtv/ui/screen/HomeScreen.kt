package dev.bogibek.jetflixtv.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.tv.foundation.lazy.list.TvLazyRow
import dev.bogibek.jetflixtv.ui.view.MovieDetailView
import dev.bogibek.jetflixtv.ui.view.MovieItem
import dev.bogibek.jetflixtv.util.Screens
import dev.bogibek.jetflixtv.util.SharedViewModel
import dev.bogibek.tvjetflix.util.movie
import dev.bogibek.tvjetflix.util.movies

@Composable
fun HomeScreen(
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {
    val selectedMovie = remember {
        mutableStateOf(movie)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {


            MovieDetailView(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                movie = selectedMovie.value
            )


            TvLazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.3f),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                items(movies.size) { position ->

                    MovieItem(
                        movie = movies[position],
                        onFocusChange = { movie ->
                            selectedMovie.value = movie
                        },
                        onItemClick = { movie ->
                            sharedViewModel.data = movie
                            navController.navigate(Screens.Movie.route)
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}