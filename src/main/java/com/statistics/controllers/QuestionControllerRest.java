package com.statistics.controllers;

import com.statistics.models.enteties.Question;
import com.statistics.services.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class QuestionControllerRest {

    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/allQuestions")
    public Iterable<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @RequestMapping(value = "/questionsOfSurvey/{id}")
    public ArrayList<Question> getQuestionsBySurvey(@PathVariable Integer id){
        return questionService.getAllQuestionsOfSurvey(id);
    }
}
