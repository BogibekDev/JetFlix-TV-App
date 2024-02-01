package dev.bogibek.jetflixtv.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.tv.foundation.lazy.list.TvLazyRow
import dev.bogibek.jetflixtv.model.Movie
import dev.bogibek.jetflixtv.ui.view.LoadingView
import dev.bogibek.jetflixtv.ui.view.MovieDetailView
import dev.bogibek.jetflixtv.ui.view.MovieItem
import dev.bogibek.jetflixtv.util.Screens
import dev.bogibek.jetflixtv.util.SharedViewModel
import dev.bogibek.jetflixtv.util.movie
import dev.bogibek.jetflixtv.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    sharedViewModel: SharedViewModel,
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val focusedMovie = remember {
        mutableStateOf<Movie?>(null)
    }

    LaunchedEffect(true) {
        viewModel.getMovieList()
    }


    if (viewModel.errorMessage.value != null) {
        Log.d("Errorcha", "HomeScreen: ${viewModel.errorMessage.value}")
    }


    LaunchedEffect(focusedMovie.value) {
        if (focusedMovie.value != null) {
            viewModel.getMovieDetail(focusedMovie.value!!.id)
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {

        if (viewModel.isLoadingList.value) LoadingView(modifier = Modifier.fillMaxSize())
        else Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {


            if (viewModel.isLoading.value) LoadingView(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )
            else MovieDetailView(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                movie = focusedMovie.value
            )


            TvLazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.3f),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                items(viewModel.movieList.value?.results?.size ?: 0) { position ->
                    MovieItem(
                        movie = viewModel.movieList.value?.results?.get(position) ?: movie,
                        onFocusChange = { movie ->
                            focusedMovie.value = movie
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