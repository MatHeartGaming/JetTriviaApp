package it.spaarkly.jettriviaapp.repository

import android.util.Log
import it.spaarkly.jettriviaapp.data.DataOrException
import it.spaarkly.jettriviaapp.model.QuestionItem
import it.spaarkly.jettriviaapp.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api : QuestionApi) {

    private val data = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions() : DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            data.loading = true
            data.data = api.getAllQuestions()
            if(!data.data.toString().isNullOrEmpty()) data.loading = false
        } catch (exc : Exception) {
            data.e = exc
            Log.d("Exception", "getAllQuestions: ${exc.localizedMessage}")
        } finally {
          data.loading = false
        }
        return data
    }

}