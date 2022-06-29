package com.example.react_aws_proj.dto;

import com.example.react_aws_proj.model.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

/** TodoEntity의 DTO 버전클래스 -> 이 클래스를 이용해 Todo아이템을 생성,수정,삭제git*/
public class TodoDTO {
    private String id;
    private String title;
    private boolean done;


    public TodoDTO(final TodoEntity entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    public static TodoEntity toEntity(final TodoDTO dto){
        return TodoEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }
}
