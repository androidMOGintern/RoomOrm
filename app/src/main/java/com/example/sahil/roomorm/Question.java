package com.example.sahil.roomorm;

/**
 * Created by sahil on 4/3/18.
 */

public class Question {

    String question,optionA,optionB,optionC,optionD;
    String id;

    public Question(String question, String optionA, String optionB, String optionC, String optionD, String id) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getId() {
        return id;
    }
}
