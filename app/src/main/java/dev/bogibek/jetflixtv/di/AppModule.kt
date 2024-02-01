package dev.bogibek.jetflixtv.di

import androidx.media3.ui.leanback.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.bogibek.jetflixtv.data.remote.ApiClient.server
import dev.bogibek.jetflixtv.data.remote.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Suppress("NAME_SHADOWING")
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getRetrofitClient(): Retrofit {
        return Retrofit
            .Builder()
            .client(buildClient())
            .baseUrl(server())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    private fun buildClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val builder = OkHttpClient.Builder()
        try {
            builder.callTimeout(1, TimeUnit.MINUTES)
                .addNetworkInterceptor(Interceptor { chain ->
                    var request = chain.request()
                    val builder = request.newBuilder()
                    builder.addHeader("Accept", "application/json")
                    request = builder.build()
                    chain.proceed(request)
                })
        } catch (e: Exception) {
            when (e) {
                is SocketTimeoutException -> {
                    throw SocketTimeoutException()
                }
            }
        }

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(interceptor)
            builder.addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun apiService(): ApiService {
        val newClient =
            OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).addInterceptor(Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                   // builder.addHeader("api_key", "99b4808386d0dc2136f0e6efe977a911")
                    builder.header("Content-Type", "application/json")
                    chain.proceed(builder.build())
                })

        return getRetrofitClient().newBuilder().client(newClient.build()).build()
            .create(ApiService::class.java)
    }


}