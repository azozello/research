package com.statistics.repositories;

import com.statistics.models.enteties.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
