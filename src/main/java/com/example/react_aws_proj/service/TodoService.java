package com.example.react_aws_proj.service;

import com.example.react_aws_proj.model.TodoEntity;
import com.example.react_aws_proj.persistence.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    public String testService(){
        // TodoEntity 생성
        TodoEntity entity = TodoEntity.builder().title("My first Todo item").build();

        // TodoEntity 저장
        todoRepository.save(entity);

        // TodoEntity 검색
        TodoEntity savedEntity = todoRepository.findById(entity.getId()).get();

        return savedEntity.getTitle();
    }

}
