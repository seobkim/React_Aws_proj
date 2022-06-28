package com.example.react_aws_proj;

import com.example.react_aws_proj.dto.ResponseDTO;
import com.example.react_aws_proj.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("test") //리소스
public class TestController {

    @GetMapping
    public String testController(){
        return "Hello World";
    }

    @GetMapping("/testGetMapping")
    public String testControllerWithPath(){
        return "Hello World! testGetMapping";
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id){
        return "Hello world! ID : " +id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return "Hello World! ID: " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody(){
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm Response DTO");
        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder().data(list).build();
        return responseDTO;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.badRequest().body(response);
    }

}
