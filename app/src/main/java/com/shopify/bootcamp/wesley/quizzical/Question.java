package com.shopify.bootcamp.wesley.quizzical;

/**
 * Created by wes on 2017-10-06.
 */

public class Question {

    private boolean answer;
    private String statement;

    public Question(String proposition, boolean answer) {
        this.answer = answer;
        this.statement = proposition;
    }

    public boolean getAnswer() {
        return answer;
    }

    public String getStatement() {
        return statement;
    }
}
