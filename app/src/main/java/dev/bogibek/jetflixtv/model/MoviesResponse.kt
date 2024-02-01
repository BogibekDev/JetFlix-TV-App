package dev.bogibek.jetflixtv.model

data class MoviesResponse(
    val page: Long,
    val results: ArrayList<Movie>,
    val totalPages: Long,
)