package dev.bogibek.jetflixtv.data.remote

object ApiClient {

    private const val IS_TESTER = true

    private const val SERVER_DEVELOPMENT = "https://api.themoviedb.org/3/"
    private const val SERVER_PRODUCTION = "https://api.themoviedb.org/3/"

    fun server() = if (IS_TESTER) SERVER_DEVELOPMENT else SERVER_PRODUCTION
}