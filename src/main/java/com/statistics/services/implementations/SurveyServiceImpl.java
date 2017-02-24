package com.statistics.services.implementations;

import com.statistics.models.enteties.Survey;
import com.statistics.repositories.SurveyRepository;
import com.statistics.services.interfaces.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImpl implements SurveyService{

    private SurveyRepository surveyRepository;

    @Autowired
    public void setSurveyRepository(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public Survey getSurveyByID(int id) {
        return surveyRepository.findOne(id);
    }

    @Override
    public Iterable<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public void insertSurvey(Survey survey) {
        surveyRepository.save(survey);
    }
}
