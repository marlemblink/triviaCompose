package com.example.triviacompose.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviacompose.data.DataOrException
import com.example.triviacompose.model.QuestionItem
import com.example.triviacompose.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository): ViewModel() {
    val data: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>>
    = mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()
            if(data.value.data.toString().isNotEmpty()) data.value.loading = false
        }
    }

    fun getTotalQuestionsCount(): Int = data.value.data?.toMutableList()?.size?:0
}