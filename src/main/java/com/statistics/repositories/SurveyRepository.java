package com.statistics.repositories;

import com.statistics.models.enteties.Survey;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey, Integer>{
}
