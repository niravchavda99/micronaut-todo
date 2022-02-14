package com.incubyte;

import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class TodoService {
  private final TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public Todo save(Todo todo) {
    return todoRepository.save(todo);
  }

  public List<Todo> getTodos(Status status) {
    return todoRepository.findByStatusOrderById(status);
  }
}
