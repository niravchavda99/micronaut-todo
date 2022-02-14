package com.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@MicronautTest
public class TodosControllerTest {

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  public void should_save_todos() {
    // Arrange
    Map todo = new HashMap();
    todo.put("title", "Remember eggs");
    todo.put("status", "OPEN");
    // ACT
    Map<String, String> response =
        client
            .toBlocking()
            .retrieve(HttpRequest.POST("/todos", todo), Argument.mapOf(String.class, String.class));
    // Assert
    Assertions.assertThat(response.get("id")).isNotNull();
    Assertions.assertThat(response.get("id")).isNotEmpty();
    Assertions.assertThat(response.get("title")).isEqualTo("Remember eggs");
    Assertions.assertThat(response.get("status")).isEqualTo("OPEN");
  }
}
