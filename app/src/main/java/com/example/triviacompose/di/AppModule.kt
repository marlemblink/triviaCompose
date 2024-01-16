package com.example.triviacompose.di

import com.example.triviacompose.network.QuestionAPI
import com.example.triviacompose.repository.QuestionRepository
import com.example.triviacompose.util.Constants
import com.google.gson.Gson
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
    //providers ex repository, vm
    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionAPI) = QuestionRepository(api)

    @Singleton
    @Provides
    fun provideQuestionAPI():QuestionAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionAPI::class.java)
    }
}