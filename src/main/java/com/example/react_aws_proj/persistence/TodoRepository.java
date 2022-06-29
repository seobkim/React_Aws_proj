package com.example.react_aws_proj.persistence;

import com.example.react_aws_proj.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity,String> {

    @Query(value = "select t from Todo t where t.userId= ?1")
    List<TodoEntity> findByUserId(String uesrId);

}
