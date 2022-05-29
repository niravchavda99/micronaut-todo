package com.incubyte;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/todos")
public class TodosController {

  @Inject
  private TodosService todosService;

  public TodosController(TodosService todosService) {
    this.todosService = todosService;
  }

  @Post
  public MutableHttpResponse<Todo> save(@Body Todo todo) {
    if (todo.getTitle() == null || todo.getTitle().isEmpty()) {
      return HttpResponse.badRequest(todo);
    }
    return HttpResponse.ok(todosService.save(todo));
  }

  @Get("/open")
  public List<Todo> open() {
    return todosService.getTodos(Status.OPEN);
  }

  @Patch
  public Todo update(@Body Todo todo) {
    return todosService.update(todo);
  }

  @Get("/closed")
  public List<Todo> closed() {
    return todosService.getTodos(Status.CLOSED);
  }

  @Get("healthcheck")
  public String checkHealth() {
    return "Up and running!";
  }

  @Get("ping")
  public String ping() {
    return "Ping!";
  }
}
