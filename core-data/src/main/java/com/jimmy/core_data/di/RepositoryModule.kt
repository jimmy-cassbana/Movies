package com.jimmy.core_data.di

import com.jimmy.core_data.data.repository.MoviesRepositoryImp
import com.jimmy.core_data.domain.repository.MoviesRepository
import com.jimmy.core_network.data.remote.module.movies.MoviesRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesCurrencyRepository(
        remoteDataSource: MoviesRemoteDataSource,
    ): MoviesRepository {
        return MoviesRepositoryImp(remoteDataSource)
    }

}
