package com.statistics.models.enteties;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int id;


    @Column(name = "survey", nullable = false, unique = true)
    private int survey;

    @Column(name = "question", nullable = false, unique = true)
    private String question;

    public Question(int survey, String question) {
        this.survey = survey;
        this.question = question;
    }

    public Question(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurvey() {
        return survey;
    }

    public void setSurvey(int survey) {
        this.survey = survey;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
