package com.example.react_aws_proj;

import com.example.react_aws_proj.dto.ResponseDTO;
import com.example.react_aws_proj.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
}
