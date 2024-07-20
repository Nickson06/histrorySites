package com.example.historicalsites.repository;

import com.example.historicalsites.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
