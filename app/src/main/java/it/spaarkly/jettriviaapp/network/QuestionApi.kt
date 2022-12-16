package it.spaarkly.jettriviaapp.network

import it.spaarkly.jettriviaapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {

    @GET("world.json")
    suspend fun getAllQuestions() : Question

}