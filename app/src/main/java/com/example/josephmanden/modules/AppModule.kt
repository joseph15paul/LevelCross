package com.example.josephmanden.modules

import com.example.josephmanden.interfaces.AllTrainsOnStationService
import com.example.josephmanden.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideAllTrainsOnStationService(retrofit: Retrofit): AllTrainsOnStationService =
        retrofit.create(AllTrainsOnStationService::class.java)

}