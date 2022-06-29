package com.example.react_aws_proj.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder                // 빌더 패턴으로 자동 생성
@NoArgsConstructor      // 파라미터 없는 기본 생성자 생성
@AllArgsConstructor     // 모든 필드 값을 파라미터로 받는 생성자 생성
@Data                   // @Getter | @Setter | @RequiredArgsConstructor | @toString | @EqualsAndHashCode 를 한번에 설정
@Entity(name = "Todo")
@Table
public class TodoEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")                      // ID를 자동생성하겠다는 뜻
    @GenericGenerator(name = "system-uuid", strategy = "uuid")      // system-uuid라는 generator를 사ㅜ믇할것
    // 오브젝트의 ID
    private String id;

    // 오브젝트를 생선한 사용자의 ID
    private String userId;

    // Todo 타이틀 (예: 운동하기)
    private String title;

    // True - todo를 완료한 경우(Checked)
    private boolean done;

}
