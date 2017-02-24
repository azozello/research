package com.statistics.repositories;

import com.statistics.models.enteties.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
