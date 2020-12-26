package com.felece.Todo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public void updateTodo(Todo todo){
        todoRepository.save(todo);
    }
}
