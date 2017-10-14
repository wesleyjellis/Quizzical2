package com.shopify.bootcamp.wesley.quizzical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LAST_ANSWER = "lastAnswer";
    private static final String QUESTION_ANSWERED = "question_answered";
    private static final String CURRENT_QUESTION = "current_question";
    private static final String SCORE = "score";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private TextView answerTextView;
    private TextView questionTextView;
    private Button nextButton;
    private Button trueButton;
    private Button falseButton;
    private boolean lastAnswer;
    private boolean questionAnswered = false;
    private Quiz quiz;
    private int currentQuestion;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        answerTextView = (TextView) findViewById(R.id.answer_text);
        questionTextView = (TextView) findViewById(R.id.question_text);


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
            public void onClick(View v) {
                nextQuestion();
            }
        });

        if (savedInstanceState != null) {
            currentQuestion = savedInstanceState.getInt(CURRENT_QUESTION, 0);
            questionAnswered = savedInstanceState.getBoolean(QUESTION_ANSWERED, false);
            lastAnswer = savedInstanceState.getBoolean(LAST_ANSWER, false);
            score = savedInstanceState.getInt(SCORE, 0);
        }

        quiz = Quiz.getInstance();

        showQuestion();

        if (questionAnswered) {
            checkAnswer(lastAnswer);
        }
    }

    private void nextQuestion() {
        currentQuestion++;
        int numQuestions = quiz.getQuestions().size();
        if (currentQuestion >= numQuestions) {
            Intent resultActivity = new Intent(this, ResultActivity.class);
            resultActivity.putExtra(ResultActivity.KEY_SCORE, score);
            resultActivity.putExtra(ResultActivity.KEY_TOTAL, numQuestions);
            startActivity(resultActivity);
        } else {
            questionAnswered = false;
            showQuestion();
        }
    }

    private void showQuestion() {
        String statement = getCurrentQuestion().getStatement();
        questionTextView.setText(statement);
        answerTextView.setText("");
        nextButton.setEnabled(false);
    }

    private Question getCurrentQuestion() {
        return quiz.getQuestions().get(currentQuestion);
    }

    private void checkAnswer(boolean answerToCheck) {
        questionAnswered = true;
        lastAnswer = answerToCheck;
        if (answerToCheck == getCurrentQuestion().getAnswer()) {
            answerTextView.setText("Correct!");
            score++;
        } else {
            answerTextView.setText("Wrong");
        }
        nextButton.setEnabled(true);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(LAST_ANSWER, lastAnswer);
        outState.putBoolean(QUESTION_ANSWERED, questionAnswered);
        outState.putInt(CURRENT_QUESTION, currentQuestion);
        outState.putInt(SCORE, score);
    }
}
