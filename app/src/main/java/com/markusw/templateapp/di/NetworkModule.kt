package com.markusw.templateapp.di

import com.google.gson.GsonBuilder
import com.markusw.templateapp.network.data.remote.api.GithubApi
import com.markusw.templateapp.network.data.remote.services.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val END_POINT = "https://api.github.com/"

    @Provides
    @Singleton
    fun provideGithubService(): GithubService {
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofitClient = Retrofit
            .Builder()
            .baseUrl(END_POINT)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return GithubService(retrofitClient.create(GithubApi::class.java))
    }

}