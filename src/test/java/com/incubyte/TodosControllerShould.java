package com.incubyte;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TodosControllerShould {

    private Todo todo;

    @Mock
    private TodoService todosService;

    @BeforeEach
    public void init(){
        todo = new Todo("Remember eggs", Status.OPEN);
    }

    @Test
    public void call_the_todo_service_to_save_todo() {
//        Arrange
        TodosController todosController = new TodosController(todosService);
//        Act
        todosController.save(todo);
//        ASsert
        Todo todoResponse = verify(todosService).save(todo);
    }
}
