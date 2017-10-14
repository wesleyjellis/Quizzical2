package com.shopify.bootcamp.wesley.quizzical;

import android.content.Context;
import android.util.Log;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.io.InputStream;

import okio.Okio;

public class QuizRepository {

    public static final String QUIZ_JSON = "quiz.json";
    private static final String LOG_TAG = QuizRepository.class.getSimpleName();
    private final Context context;

    public QuizRepository(Context context) {
        this.context = context;
    }


    public Quiz getQuiz() {
        InputStream assetInputStream;
        try {
            assetInputStream = context.getAssets().open(QUIZ_JSON);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Could open quiz parse json", e);
            return null;
        }

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Quiz> jsonAdapter = moshi.adapter(Quiz.class);

        try {
            Quiz quiz = jsonAdapter.fromJson(Okio.buffer(Okio.source(assetInputStream)));
            return quiz;
        } catch (IOException e) {
            Log.e(LOG_TAG, "Could not parse json", e);
            return null;
        }

    }

}
