package com.statistics.services.interfaces;

import com.statistics.models.enteties.Survey;
import org.springframework.stereotype.Service;

@Service
public interface SurveyService {

    Survey getSurveyByID(int id);

    Iterable<Survey> getAllSurveys();

    void insertSurvey(Survey survey);
}
