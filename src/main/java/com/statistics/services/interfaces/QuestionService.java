package com.statistics.services.interfaces;

import com.statistics.models.enteties.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface QuestionService {

    Question getQuestionByID(int id);

    Iterable<Question> getAllQuestions();

    ArrayList<Question> getAllQuestionsOfSurvey(int survey);

    void insertQuestion(Question question);
}
