package com.example.triviacompose.network

import com.example.triviacompose.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}