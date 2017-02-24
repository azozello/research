package com.statistics.controllers;

import com.statistics.models.classes.SurveyTransfer;
import com.statistics.models.enteties.Question;
import com.statistics.models.enteties.Survey;
import com.statistics.services.interfaces.QuestionService;
import com.statistics.services.interfaces.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveyControllerRest {

    private SurveyService surveyService;
    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void setSurveyService(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping(value = "/allSurveys")
    public Iterable<Survey> getAllSurveys(){
        return surveyService.getAllSurveys();
    }

    @RequestMapping(value = "/getSurvey/{id}")
    public Survey getSurvey(@PathVariable Integer id){
        try {
            return surveyService.getSurveyByID(id);
        } catch (Exception e){
            Survey exceptionSurvey = new Survey();
            exceptionSurvey.setDescription(e.getMessage());
            return exceptionSurvey;
        }
    }

    private int surveyID = 0;

    @RequestMapping(value = "/createSurvey", method = RequestMethod.POST)
    public int createSurvey(@RequestBody SurveyTransfer surveyTransfer){
        surveyService.insertSurvey(new Survey(surveyTransfer.getTitle(),surveyTransfer.getDescription()));
        surveyService.getAllSurveys().forEach(value -> setSurveyID(value.getId()));
        for (String question : surveyTransfer.getQuestions()){
            questionService.insertQuestion(new Question(getSurveyID(),question));
        }
        return getSurveyID();
    }

    private void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
    }

    public int getSurveyID() {
        return surveyID;
    }
}
