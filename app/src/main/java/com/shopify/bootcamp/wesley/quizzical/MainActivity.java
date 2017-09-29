package com.shopify.bootcamp.wesley.quizzical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getSimpleName();

    private TextView questionTextView;
    private TextView answerTextView;
    private Button trueButton;
    private Button falseButton;
    private int currentQuestion = 0;
    private int numCorrect = 0;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = (TextView) findViewById(R.id.question_text);
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

        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQuestion < QuestionBank.getQuestion().size() - 1) {
                    currentQuestion++;
                    showCurrentQuestion();
                } else {
                    showResults();
                }
            }
        });


        showCurrentQuestion();

    }

    private void showResults() {
        Intent resultIntent = new Intent(this, ResultActivity.class);
        resultIntent.putExtra(ResultActivity.SCORE, numCorrect);
        startActivity(resultIntent);
    }

    private void showCurrentQuestion() {
        questionTextView.setText(getCurrentQuestion().getProposition());
        answerTextView.setText("");
        trueButton.setEnabled(true);
        falseButton.setEnabled(true);
        nextButton.setVisibility(View.GONE);
    }

    private void checkAnswer(boolean answerToCheck) {
        if (answerToCheck == getCurrentQuestion().getAnswer()) {
            answerTextView.setText("Correct!");
            numCorrect++;
        } else {
            answerTextView.setText("Wrong");
        }
        Log.wtf(LOG_TAG, "Correct so far: " + numCorrect);
        falseButton.setEnabled(false);
        trueButton.setEnabled(false);
        nextButton.setVisibility(View.VISIBLE);
    }

    private QuizQuestion getCurrentQuestion() {
        return QuestionBank.getQuestion().get(currentQuestion);
    }
}
