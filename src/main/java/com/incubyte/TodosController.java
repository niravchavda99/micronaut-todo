package com.incubyte;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/todos")
public class TodosController {
    @Inject
    private TodoService todoService;

    public TodosController(TodoService todosService) {
        this.todoService = todosService;
    }

    @Post
    public Todo save(@Body Todo todo) {
        return todoService.save(todo );
    }
}
