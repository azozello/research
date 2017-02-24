package com.statistics.models.enteties;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int id;


    @Column(name = "question", nullable = false, unique = true)
    private int question;

    @Column(name = "answer", nullable = false, unique = true)
    private String answer;

    @Column(name = "user", nullable = false, unique = true)
    private int user;

    public Answer(){}

    public Answer(int question, String answer, int user) {
        this.question = question;
        this.answer = answer;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
