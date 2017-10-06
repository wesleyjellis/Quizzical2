package com.shopify.bootcamp.wesley.quizzical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LAST_ANSWER = "lastAnswer";
    private static final String QUESTION_ANSWERED = "question_answered";
    private static String LOG_TAG = MainActivity.class.getSimpleName();

    private TextView answerTextView;
    private Button trueButton;
    private Button falseButton;
    private boolean lastAnswer;
    private boolean questionAnswered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTextView = (TextView) findViewById(R.id.answer_text);

        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                Log.wtf(LOG_TAG, "True button clicked");
            }
        });

        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                Log.wtf(LOG_TAG, "True button clicked");
            }
        });

        if (savedInstanceState != null) {
            questionAnswered = savedInstanceState.getBoolean(QUESTION_ANSWERED, false);
            lastAnswer = savedInstanceState.getBoolean(LAST_ANSWER, false);
        }

        if (questionAnswered) {
            checkAnswer(lastAnswer);
        }
    }

    private void checkAnswer(boolean answerToCheck) {
        questionAnswered = true;
        lastAnswer = answerToCheck;
        if (answerToCheck == true) {
            answerTextView.setText("Correct!");
        } else {
            answerTextView.setText("Wrong");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(LAST_ANSWER, lastAnswer);
        outState.putBoolean(QUESTION_ANSWERED, questionAnswered);
    }
}
