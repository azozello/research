package com.statistics.services.implementations;

import com.statistics.models.enteties.Question;
import com.statistics.repositories.QuestionRepository;
import com.statistics.services.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question getQuestionByID(int id) {
        return questionRepository.findOne(id);
    }

    @Override
    public Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public ArrayList<Question> getAllQuestionsOfSurvey(int survey) {
        Iterable<Question> allQuestions = questionRepository.findAll();
        ArrayList<Question> toReturn = new ArrayList<>();
        for (Question question: allQuestions) {
            if (question.getSurvey()==survey) toReturn.add(question);
        }
        return toReturn;
    }

    @Override
    public void insertQuestion(Question question) {
        questionRepository.save(question);
    }
}
