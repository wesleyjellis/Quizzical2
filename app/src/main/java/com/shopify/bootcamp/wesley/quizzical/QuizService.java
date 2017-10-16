package com.shopify.bootcamp.wesley.quizzical;

import retrofit2.Call;
import retrofit2.http.GET;


public interface QuizService {

    @GET("cdn/quiz.json")
    Call<Quiz> getQuiz();
}
