package com.example.react_aws_proj.service;

import com.example.react_aws_proj.model.TodoEntity;
import com.example.react_aws_proj.persistence.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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

    public List<TodoEntity> create(final TodoEntity entity){
        //Validations
        validate(entity);

        todoRepository.save(entity);

        log.info("Entity Id : {}",entity.getId());
        return todoRepository.findByUserId(entity.getUserId());
    }

    private void validate(final TodoEntity entity){
        if(entity == null){
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }

        if(entity.getUserId() == null){
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }

    public List<TodoEntity> retrieve(final String userId){
        return todoRepository.findByUserId(userId);
    }

    public List<TodoEntity> update(final TodoEntity entity){
        // (1) 저장할 entity가 유효한지 확인
        validate(entity);

        //(2) 넘겨받은 엔티티 ID를 이용해 TodoEntity를 가져온다. 존재 유뮤 확인 후 업데이트를 위해
        final Optional<TodoEntity> orginal = todoRepository.findById(entity.getId());

        orginal.ifPresent(todo -> {
            //(3) 반환된 TodoEntity가 존재하면 값을 새 entity 값으로 덮어 씌운다.
            todo.setTitle(entity.getTitle());
            todo.setDone(entity.isDone());

            // (4) 새 데이터베이스에 새 값을 저장한다.
            todoRepository.save(todo);
        });


        // Retrive Todo에서 만든 메서드를 이용해 사용자의 모든 Todo리스트를 리턴한다.
        return retrieve(entity.getUserId());
    }

    public List<TodoEntity> delete(final TodoEntity entity){
        // 있는 게시물인지 검증
        validate(entity);

        try{
            todoRepository.delete(entity);
        }catch (Exception e){
            log.error("error deleting entity ",entity.getId(), e);

            // 컨트롤러로 exception을 보낸다.
            // 데이터베이스 내부 로직을 캡슐화하려면 e를 리턴하지 않고 새 exception 객체를 리턴.
            throw new RuntimeException("error deleting entity" + entity.getId());
        }

        //새 TODO리스트를 가져와 리턴한다.
        return retrieve(entity.getUserId());
    }
}
