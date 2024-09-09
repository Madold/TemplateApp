package com.markusw.templateapp.di

import android.content.Context
import com.markusw.templateapp.core.data.local.dao.RepositoriesDao
import com.markusw.templateapp.home.data.repository.AndroidRepositoryImpl
import com.markusw.templateapp.home.domain.repository.Repository
import com.markusw.templateapp.network.data.remote.services.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideRepository(
        githubService: GithubService,
        repositoriesDao: RepositoriesDao,
       @ApplicationContext context: Context
    ): Repository {
        return AndroidRepositoryImpl(
            githubService,
            repositoriesDao,
            context
        )
    }

}