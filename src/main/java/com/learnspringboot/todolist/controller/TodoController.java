package com.learnspringboot.todolist.controller;

import com.learnspringboot.todolist.entity.Todo;
import com.learnspringboot.todolist.exceptions.TodoNotFoundException;
import com.learnspringboot.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    private final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

    @PostMapping("/todos")
    public Todo saveTodo(@Valid @RequestBody Todo todo){
        LOGGER.info("Inside SaveTodo");
        return todoService.saveTodo(todo);

    }

    @GetMapping("/todos")
    public List<Todo> getTodoList(){
        LOGGER.info("Inside getTodoList");
        return todoService.getTodoList();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") Integer todoId) throws TodoNotFoundException {
        LOGGER.info("Inside getTodoById");
        return todoService.getTodoById(todoId);
    }

    @DeleteMapping("todos/{id}")
    public String deleteTodoById(@PathVariable("id") Integer todoId){
         LOGGER.info("Inside deleteTodoById");
         todoService.deleteTodoById(todoId);
         return "Todo Deleted Successfully";
    }

    @PutMapping("todos/{id}")
    public Todo updateTodo(@PathVariable("id") Integer todoId,@RequestBody Todo todo){
        return todoService.updateTodo(todoId,todo);

    }
}
