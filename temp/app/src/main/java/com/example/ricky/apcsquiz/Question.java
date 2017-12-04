package com.example.ricky.apcsquiz;

/**
 * Created by wur3 on 11/20/2017.
 */

import java.lang.reflect.Array;

public class Question {

    private String question;
    private String[] choice = new String[4];
    private String answer;
    private int ID;


    public Question(){


        question="";
        choice[0]="";
        choice[1]="";
        choice[2]="";
        choice[3]="";
        answer="";

    }
    public Question(String question, String[] choices, String answer) {
        this.question = question;
        this.choice[0] = choices[0];
        this.choice[1] = choices[1];
        this.choice[2] = choices[2];
        this.choice[3] = choices[3];
        this.answer = answer;
    }

    public String getQuestion(){ return question; }
    public String getChoice(int i){ return choice[i]; }
    public String getAnswer(){ return answer; }
    public void setAnswer(String answer){ this.answer = answer; }
    public void setChoice(int i, String choice){ this.choice[i]=choice; }
    public void setQuestion(String question) { this.question = question; }

}