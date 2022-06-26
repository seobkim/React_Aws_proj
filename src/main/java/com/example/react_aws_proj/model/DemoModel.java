package com.example.react_aws_proj.model;


import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder                    // 빌더 패턴으로 자동 생성
@RequiredArgsConstructor    // final이 붙거나 @NotNull이 붙은 필드의 생성자 자동 생성해주는 어노테이션
public class DemoModel {

    @NonNull
    private String id;
    
}
