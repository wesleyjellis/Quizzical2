package com.shopify.bootcamp.wesley.quizzical;

import java.util.ArrayList;
import java.util.List;


public class Quiz {

    private List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
