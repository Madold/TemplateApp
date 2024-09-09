package com.markusw.templateapp.di

import android.content.Context
import androidx.room.Room
import com.markusw.templateapp.core.data.local.dao.RepositoriesDao
import com.markusw.templateapp.core.data.local.db.RepositoriesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideRepositoryDatabase(@ApplicationContext context: Context): RepositoriesDatabase {
        return Room.databaseBuilder(
            context,
            RepositoriesDatabase::class.java,
            "repositories-database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepositoryDatabaseDao(
        db: RepositoriesDatabase
    ): RepositoriesDao {
        return db.dao
    }

}