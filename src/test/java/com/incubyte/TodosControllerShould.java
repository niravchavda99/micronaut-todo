package com.incubyte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TodosControllerShould {

    private Todo todo;

    @Mock
    private TodosService todosService;

    @BeforeEach
    public void init() {
        todo = new Todo("Remember eggs", Status.OPEN);
    }

    @Test
    void call_the_todo_service_to_save_todo() {
        //        Arrange
        TodosController todosController = new TodosController(todosService);
        //        Act
        todosController.save(todo);
        //        ASsert
        Todo todoResponse = verify(todosService).save(todo);
    }

    @Test
    void invoke_todos_service_to_retrieve_open_todos() {
        //        Arrange
        TodosController todosController = new TodosController(todosService);
        //        Act
        List<Todo> todos = todosController.open();
        //        Assert
        verify(todosService).getTodos(Status.OPEN);
    }

    @Test
    public void mark_an_open_todo_as_closed() {
        TodosController todosController = new TodosController(todosService);
        Todo todo = new Todo("Title", Status.OPEN);
        todo.setId(1L);
        todosController.update(todo);

        verify(todosService).update(todo);
    }
}
