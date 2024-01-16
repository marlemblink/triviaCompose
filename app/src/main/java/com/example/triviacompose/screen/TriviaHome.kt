package com.example.triviacompose.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviacompose.MainActivity
import com.example.triviacompose.component.Questions
import com.example.triviacompose.model.Question
import com.example.triviacompose.vm.QuestionViewModel

    @Composable
    fun TriviaHome(viewModel: QuestionViewModel = hiltViewModel()) {
        Questions(viewModel = viewModel)
}