package dev.bogibek.jetflixtv.model

import java.io.Serializable

data class Movie(
    val id: Long,
    val title: String,
    val description: String,
    val rating: Double,
    val category: String,
    val thumbnail: String,
    val images: List<String>,
    val videoUrl: String = "https://storage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"
):Serializable
