package jpabook.jpabook.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name; // 이름

    private String city; // 도시
    private String street; // 거리
    private String zipcode; // 우편번호
}
