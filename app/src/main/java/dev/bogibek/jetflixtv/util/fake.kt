package dev.bogibek.jetflixtv.util

import dev.bogibek.jetflixtv.model.Genre
import dev.bogibek.jetflixtv.model.Movie


val movie = Movie(
    id = 1,
    title = "Sample Movie",
    overview = "A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \\\"fight clubs\\\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.",
    rating = 8.5,
    backdrop_path = "/hZkgoQYus5vegHoetLkCJzb17zJ.jpg",
    vote_average = 4.2,
    release_date = "2023-07-01",
    category = "Action",
    thumbnail = "sample_thumbnail",
    images = listOf(
        "https://cdn.dummyjson.com/product-images/1/1.jpg",
        "https://cdn.dummyjson.com/product-images/1/2.jpg",
        "https://cdn.dummyjson.com/product-images/1/3.jpg",
        "https://cdn.dummyjson.com/product-images/1/4.jpg",
        "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
    ),
    genres = listOf(
        Genre(id = 1, name = "Drama"),
        Genre(id = 2, name = "Thriller"),
        Genre(id = 3, name = "Sci-Fi")
    ),
    videoUrl = "https://storage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"
)


val movies = listOf<Movie>(
    movie.copy(title = "Title1"),
    movie.copy(title = "Title2"),
    movie.copy(title = "Title3"),
    movie.copy(title = "Title4"),
    movie.copy(title = "Title5"),
    movie.copy(title = "Title6"),

    )