package com.shopify.bootcamp.wesley.quizzical;

/**
 * Created by wes on 2017-09-25.
 */

public class QuizQuestion {

    private String proposition;
    private boolean answer;

    public QuizQuestion(String proposition, boolean answer) {
        this.proposition = proposition;
        this.answer = answer;
    }

    public String getProposition() {

        return proposition;
    }

    public boolean getAnswer() {
        return answer;
    }
}
