package com.incubyte;

import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class TodosService {
    private final TodosRepository todosRepository;

    public TodosService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    public Todo save(Todo todo) {
        return todosRepository.save(todo);
    }

    public List<Todo> getTodos(Status status) {
        return todosRepository.findByStatusOrderById(status);
    }

    public Todo update(Todo todo) {
        return todosRepository.update(todo);
    }
}
