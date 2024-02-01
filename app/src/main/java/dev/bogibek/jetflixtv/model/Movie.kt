package dev.bogibek.jetflixtv.model

import java.io.Serializable

data class Movie(
    val id: Long,
    val title: String,
    val overview: String,
    val rating: Double,
    val backdrop_path: String,
    val vote_average: Double,
    val release_date: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>,
    val genres: List<Genre>,
    val videoUrl: String? = "https://storage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"
):Serializable

data class Genre(
    val id: Int,
    val name: String
):Serializable
