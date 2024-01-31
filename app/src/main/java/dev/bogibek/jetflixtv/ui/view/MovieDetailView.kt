package dev.bogibek.jetflixtv.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import dev.bogibek.jetflixtv.model.Movie
import dev.bogibek.tvjetflix.util.movie

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieDetailView(
    modifier: Modifier = Modifier,
    movie: Movie
) {

    Box(
        modifier = modifier
            .background(color = Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Text(text = movie.title)
    }

}

@Preview
@Composable
fun MovieDetailViewPreview() {
    MovieDetailView(movie = movie)
}