package com.example.react_aws_proj;

import com.example.react_aws_proj.dto.ResponseDTO;
import com.example.react_aws_proj.dto.TodoDTO;
import com.example.react_aws_proj.model.TodoEntity;
import com.example.react_aws_proj.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("todo")
public class TodoController {

    // @Autowired 어노테이션이 아닌 생성자 주입 권장
    private final TodoService todoService;
    TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/test")
    public ResponseEntity testTodo(){
        String str = todoService.testService();
        List<String> list = new ArrayList<>();
        list.add(str);

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto){
        try{
            String temporaryUserId = "temporary-user";

            // (1) TodoEntity로 변환한다.
            TodoEntity entity = TodoDTO.toEntity(dto);

            // (2) id를 null로 ㄹ초기화한다. 생성 당시에는 id가 없어여 하기 때문이다.
            entity.setId(null);

            // (3) 임시 사용자 id를 설정해준다. 이부분은 4장 인증과 인가에서 수정 예정.
            // 지금은 인증과 인가기능이 없으므로 한 사용자(temporary-user)만 로그인 없이 사용할 수 있는 애플리케이션임
            entity.setUserId(temporaryUserId);

            // (4) 서비스를 이용해 TodoEntity를 생성한다.
            List<TodoEntity> entities = todoService.create(entity);

            // (5) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환한다.
            List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

            // (6) 변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화한다.
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

            // (7) ResponseDTO를 리턴
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            // (8) 혹시 예외가 있는 경우 dto 대신 error 메시지를 넣어 리턴
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<?> retrieveTodoList(){
        String temporaryUserId = "temporary-user";      //temporary user id

        // (1) 서비스 메소드의 retrieve() 메소드를 사용해 Todo리스트를 가져온다.
        List<TodoEntity> entities = todoService.retrieve(temporaryUserId);

        //(2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 반환
        List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

        //(3) 변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화한다.
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto){
        String tempId = "temporary-user";

        // (1) dto를 entity로 변환한다.
        TodoEntity entity = TodoDTO.toEntity(dto);

        // (2) id를 temporaryUserId로 초기화한다 -> 4장 수정 예정
        entity.setUserId(tempId);

        // (3) 서비스를 이용해 entity를 업데이트
        List<TodoEntity> entities = todoService.update(entity);

        // (4) 자바 스트림을 이용해 entity를 dto로 변환
        List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

        // (5) dtos를 response Dto로 초기화
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

        // (6) ResponseDTO 리턴
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTodo(@RequestBody TodoDTO dto){
        try{
            String tempId = "temporary-user";

            //dto -> entity 로 변환
            TodoEntity entity = TodoDTO.toEntity(dto);

            entity.setUserId(tempId);

            List<TodoEntity> entities = todoService.delete(entity);

            List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        }catch (Exception e){

            String error = e.getMessage();

            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();

            return ResponseEntity.badRequest().body(response);
        }
    }
}
