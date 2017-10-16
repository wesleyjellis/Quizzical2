package com.shopify.bootcamp.wesley.quizzical;

import java.util.ArrayList;
import java.util.List;


public class Quiz {

    private String title;
    private int id;
    private List<Question> questions = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
