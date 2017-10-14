package com.shopify.bootcamp.wesley.quizzical;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by wes on 2017-10-12.
 */

public class ResultActivity extends AppCompatActivity {

    public static final String KEY_TOTAL = "total";
    public static final String KEY_SCORE = "score";

    private TextView resultTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = (TextView) findViewById(R.id.result_text);

        Intent intent = getIntent();
        int score = intent.getIntExtra(KEY_SCORE, -1);
        int total = intent.getIntExtra(KEY_TOTAL, -1);

        String result = String.format("%d / %d", score, total);
        resultTextView.setText(result);
    }
}
