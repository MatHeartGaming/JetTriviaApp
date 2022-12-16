package it.spaarkly.jettriviaapp.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.spaarkly.jettriviaapp.data.DataOrException
import it.spaarkly.jettriviaapp.model.QuestionItem
import it.spaarkly.jettriviaapp.repository.QuestionRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository) : ViewModel() {

    val data : MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> = mutableStateOf(
        DataOrException(null, true, Exception(""))
    )

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value = repository.getAllQuestions()
        }
    }

}