package com.example.sahil.roomorm;

import com.orm.dsl.Table;

import java.io.Serializable;

/**
 * Created by sahil on 19/1/18.
 */

@Table
public class Sample_Question_Model implements Serializable {

    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sample_Question_Model() {

    }

    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;

    int questionId;
    String time;
    String type;

    String correctAns;

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sample_Question_Model(String question, String optionA, String optionB, String optionC, String optionD, int questionId) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.questionId = questionId;
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
}