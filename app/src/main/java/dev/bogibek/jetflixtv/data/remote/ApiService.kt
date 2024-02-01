package dev.bogibek.jetflixtv.data.remote

import dev.bogibek.jetflixtv.model.Movie
import dev.bogibek.jetflixtv.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("movie/{id}")
    suspend fun getMovieById(
        @Path("id") id: Long,
        @Query("api_key") api_key: String = "99b4808386d0dc2136f0e6efe977a911",
    ): Response<Movie>


    @GET("movie/top_rated")
    suspend fun getTopMovies(
        @Query("api_key") api_key: String = "99b4808386d0dc2136f0e6efe977a911",
    ):Response<MoviesResponse>
}