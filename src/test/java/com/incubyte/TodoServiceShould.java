package com.incubyte;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TodoServiceShould {
    private Todo todo;

    @Mock
    private TodoRepository todoRepository  ;

    @BeforeEach
    public void init(){
        todo = new Todo("Remember eggs", Status.OPEN);
    }

    @Test
    public void save_todo_to_persist_in_repository() {
//        Arrange
        TodoService todoService = new TodoService(todoRepository);
//        Act
        todoService.save(todo);
//        ASsert
        Todo todoResponse = verify(todoRepository).save(todo);
    }
}
