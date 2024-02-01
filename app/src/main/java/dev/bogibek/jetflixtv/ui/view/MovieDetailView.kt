package dev.bogibek.jetflixtv.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.rememberAsyncImagePainter
import dev.bogibek.jetflixtv.model.Movie
import dev.bogibek.jetflixtv.util.movie

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieDetailView(
    modifier: Modifier = Modifier,
    movie: Movie?
) {
    var imageUrl by remember { mutableStateOf("") }

    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(
            Color.Black,
            Color(0x00FFFFFF)
        ),
        startX = 600f,
        endX = 800f,
    )

    Box(
        modifier = modifier.background(Color.White)
    ) {
        if (movie != null) {
            imageUrl = "https://image.tmdb.org/t/p/w500${movie.backdrop_path}"


            Image(
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .fillMaxWidth(1f)
                    .align(Alignment.TopEnd)
            )


            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(brush = gradientBrush)
                    .fillMaxWidth(.6f)
                    .padding(start = 30.dp, top = 25.dp, end = 60.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = movie.title,
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontStyle = MaterialTheme.typography.headlineSmall.fontStyle
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Text(
                        text = movie.vote_average.toString(),
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.Green
                        )
                    )

                    Text(
                        text = movie.release_date.substring(0, 4),
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    )
                }

                Text(
                    text = movie.overview,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                )

            }
        } else {
            Text(text = "NO DATA")
        }
    }

}

@Preview(device = Devices.TV_1080p)
@Composable
fun MovieDetailViewPreview() {
    MovieDetailView(movie = movie)
}