package com.incubyte;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface TodosRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByStatusOrderById(Status status);
}
