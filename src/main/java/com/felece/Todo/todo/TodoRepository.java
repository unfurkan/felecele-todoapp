package com.felece.Todo.todo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository  extends CrudRepository<Todo,Integer> {

    List<Todo> findByTodoUserUserId(Integer id);

    Optional<Todo> findByTodoId(Integer todoId);

    void deleteByTodoId(Integer todoId);

}
