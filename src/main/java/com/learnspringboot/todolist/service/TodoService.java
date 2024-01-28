package com.learnspringboot.todolist.service;

import com.learnspringboot.todolist.entity.Todo;
import com.learnspringboot.todolist.exceptions.TodoNotFoundException;

import java.util.List;

public interface TodoService {
    Todo saveTodo(Todo todo);

    List<Todo> getTodoList();

    Todo getTodoById(Integer todoId) throws TodoNotFoundException;

    void deleteTodoById(Integer todoId);

    Todo updateTodo(Integer todoId, Todo todo);
}
