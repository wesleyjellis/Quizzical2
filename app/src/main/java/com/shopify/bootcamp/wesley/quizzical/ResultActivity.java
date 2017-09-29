package com.shopify.bootcamp.wesley.quizzical;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by wes on 2017-09-25.
 */

public class ResultActivity extends AppCompatActivity {

    public static final String SCORE = "score";
    private TextView resultTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = (TextView) findViewById(R.id.result_text);

        Intent intent = getIntent();
        int result = intent.getIntExtra(SCORE, -1);

        resultTextView.setText("" + result);
    }
}
