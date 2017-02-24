package com.statistics.services.interfaces;

import com.statistics.models.enteties.Answer;
import com.statistics.models.enteties.Question;
import org.springframework.stereotype.Service;

@Service
public interface AnswerService {

    Answer getAnswerByID(int id);

    Iterable<Answer> getAllAnswers();

    Iterable<Answer> getAnswersByQuestion(Question question);

    void insertAnswer(Answer answer);

    void insertAnswers(Iterable<Answer> answers);
}
