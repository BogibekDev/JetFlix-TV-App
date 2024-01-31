package dev.bogibek.jetflixtv.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import coil.compose.SubcomposeAsyncImage
import dev.bogibek.jetflixtv.model.Movie
import dev.bogibek.tvjetflix.util.movie

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieItem(
    movie: Movie,
    onFocusChange: ((Movie) -> Unit)? = null,
    onItemClick: (Movie) -> Unit,
) {

    Card(
        modifier = Modifier
            .aspectRatio(16 / 9f)
            .onFocusChanged {
                onFocusChange?.invoke(movie)
            },

        onClick = {
            onItemClick.invoke(movie)
        }
    ) {

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = movie.thumbnail,
                contentDescription = "",
                loading = {
                    LoadingView()
                },
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color(0x20000000))
                        .padding(16.dp),

                    ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = movie.title,
                            color = Color.White,
                        )

                        RatingBar(rating = movie.rating)
                    }

                    Text(
                        text = movie.description,
                        fontSize = 10.sp,
                        color = Color.White,
                        maxLines = 1,
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun Preview() {
    MovieItem(
        movie = movie
    ) {}
}
