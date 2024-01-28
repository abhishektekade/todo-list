package com.learnspringboot.todolist.service;

import com.learnspringboot.todolist.entity.Todo;
import com.learnspringboot.todolist.exceptions.TodoNotFoundException;
import com.learnspringboot.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(Integer todoId) throws TodoNotFoundException {
        Optional<Todo> todo = todoRepository.findById(todoId);
        if (!todo.isPresent()){
            throw new TodoNotFoundException("Todo Is not Available");
        }
        return todo.get();
    }

    @Override
    public void deleteTodoById(Integer todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    public Todo updateTodo(Integer todoId, Todo todo) {
        Todo uTodo = todoRepository.findById(todoId).get();
        uTodo.setTodoName(todo.getTodoName());
        return todoRepository.save(uTodo);
    }
}
