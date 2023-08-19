package com.jimmy.core_network.di

import com.jimmy.core_arch.CoroutineDispatchers
import com.jimmy.core_network.data.remote.module.movies.MoviesApi
import com.jimmy.core_network.data.remote.module.movies.MoviesRemoteDataSource
import com.jimmy.core_network.data.remote.module.movies.MoviesRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesRemoteModule {

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Singleton
    @Provides
    fun providesRemoteDataSource(
        api: MoviesApi,
        coroutineDispatchers: CoroutineDispatchers
    ): MoviesRemoteDataSource {
        return MoviesRemoteDataSourceImp(api, coroutineDispatchers)
    }
}