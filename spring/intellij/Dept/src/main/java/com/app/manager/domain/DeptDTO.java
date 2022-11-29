package com.app.manager.domain;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptDTO {

    @Min(value = 1)
    @Max(value = 99)
    @Positive // 양수만 입력 가능
    private int deptno;

    @NotEmpty // 문자열이 비어있지 않은 상태, List -> 요소의 개수가 비어있는지 여부 확인
    private String dname;

    @NotEmpty // "" fail " " pass
    private String loc;

}

/*

@Future : 현재 시간보다 미래여야 함 (ex. 해야하는 일 입력받을 때)
@Email : 이메일 체크
@NotBlank : empty보다 엄격함. " " 공백 문자열도 체크해줌(허용X -> fail)
@NotNull : null값이 아니어야 함

 */
