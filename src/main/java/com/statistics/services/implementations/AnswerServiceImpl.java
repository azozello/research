package com.statistics.services.implementations;

import com.statistics.models.enteties.Answer;
import com.statistics.models.enteties.Question;
import com.statistics.repositories.AnswerRepository;
import com.statistics.services.interfaces.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public void setAnswerRepository(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer getAnswerByID(int id) {
        return answerRepository.findOne(id);
    }

    @Override
    public Iterable<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public ArrayList<Answer> getAnswersByQuestion(Question question) {
        Iterable<Answer> allAnswers = answerRepository.findAll();
        ArrayList<Answer> answersToSend = new ArrayList<>();
        for (Answer answer : allAnswers){
            if (answer.getQuestion()==question.getId()) answersToSend.add(answer);
        }
        return answersToSend;
    }

    @Override
    public void insertAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void insertAnswers(Iterable<Answer> answers) {
        for (Answer answer : answers) answerRepository.save(answer);
    }
}
