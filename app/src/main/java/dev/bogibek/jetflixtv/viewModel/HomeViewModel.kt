package dev.bogibek.jetflixtv.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.bogibek.jetflixtv.data.repository.HomeRepository
import dev.bogibek.jetflixtv.model.Movie
import dev.bogibek.jetflixtv.model.MoviesResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _loadingList = mutableStateOf(false)
    val isLoadingList = _loadingList


    private val _loading= mutableStateOf(false)
    val isLoading = _loading

    private val _movieList = mutableStateOf<MoviesResponse?>(null)
    val movieList = _movieList


    private val _movie = mutableStateOf<Movie?>(null)
    val movie = _movie

    private val _error = mutableStateOf<String?>(null)
    val errorMessage = _error


    fun getMovieList() = viewModelScope.launch {
        _loadingList.value = true

        try {

            val response = repository.getTopRated()

            if (response.isSuccessful) {
                _movieList.value = response.body()
            } else {
                _error.value = response.message() ?: ""
            }


        } catch (e: Exception) {
            _error.value = e.message
        } finally {
            _loadingList.value = false
        }

    }


    fun getMovieDetail(id: Long) = viewModelScope.launch {
        _loading.value = true

        try {

            val response = repository.getMovieDetail(id)

            if (response.isSuccessful) {
                _movie.value = response.body()
            } else {
                _error.value = response.message() ?: ""
            }


        } catch (e: Exception) {
            _error.value = e.message
        } finally {
            _loading.value = false
        }
    }

}