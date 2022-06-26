package com.example.react_aws_proj.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder                // 빌더 패턴으로 자동 생성
@NoArgsConstructor      // 파라미터 없는 기본 생성자 생성
@AllArgsConstructor     // 모든 필드 값을 파라미터로 받는 생성자 생성
@Data                   // @Getter | @Setter | @RequiredArgsConstructor | @toString | @EqualsAndHashCode 를 한번에 설정
public class TodoEntity {

    // 오브젝트의 ID
    private String id;

    // 오브젝트를 생선한 사용자의 ID
    private String userId;

    // Todo 타이틀 (예: 운동하기)
    private String title;

    // True - todo를 완료한 경우(Checked)
    private boolean done;

}
