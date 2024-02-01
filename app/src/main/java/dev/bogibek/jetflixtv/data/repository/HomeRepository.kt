package dev.bogibek.jetflixtv.data.repository

import dev.bogibek.jetflixtv.data.remote.ApiService
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMovieDetail(id: Long) = apiService.getMovieById(id)
    suspend fun getTopRated() = apiService.getTopMovies()
}