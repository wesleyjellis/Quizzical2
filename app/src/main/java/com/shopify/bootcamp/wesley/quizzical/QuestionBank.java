package com.shopify.bootcamp.wesley.quizzical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wes on 2017-09-25.
 */

public class QuestionBank {

    private QuestionBank() {

    }

    public static List<QuizQuestion> getQuestion() {
        return Arrays.asList(
                new QuizQuestion("Does the sun go around the earth?", true),
                new QuizQuestion("The sky is red", false)
        );
    }
}
