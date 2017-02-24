package com.statistics.models.classes;

public class SurveyTransfer {

    private String title;
    private String description;
    private String[] questions;

    public SurveyTransfer(String title, String description, String[] questions) {
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public SurveyTransfer() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getQuestions() {
        return questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }
}
