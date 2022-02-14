package com.incubyte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TodosServiceShould {
  private Todo todo;

  @Mock private TodosRepository todosRepository;

  @BeforeEach
  public void init() {
    todo = new Todo("Remember eggs", Status.OPEN);
  }

  @Test
  void save_todo_to_persist_in_repository() {
    //        Arrange
    TodosService todosService = new TodosService(todosRepository);
    //        Act
    todosService.save(todo);
    //        ASsert
    Todo todoResponse = verify(todosRepository).save(todo);
  }

  @Test
  void find_todos_by_status() {
    //        Arrange
    TodosService todosService = new TodosService(todosRepository);
    //        Act
    todosService.getTodos(Status.OPEN);
    //        ASsert
    verify(todosRepository).findByStatusOrderById(Status.OPEN);
  }

  @Test
  public void update_an_open_todo_as_closed() {
    TodosService todosService = new TodosService(todosRepository);
    Todo todo = new Todo("Title", Status.OPEN);
    todo.setId(1L);
    todosService.update(todo);

    verify(todosRepository).update(todo);
  }

}
