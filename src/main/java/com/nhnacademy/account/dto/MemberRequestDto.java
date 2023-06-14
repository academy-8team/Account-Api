/**
 * packageName :  com.nhnacademy.account.dto
 * fileName : MemberRequestDto
 * author :  ichunghui
 * date : 2023/06/06
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.account.dto;

import com.nhnacademy.account.entity.MemberGrade;
import com.nhnacademy.account.entity.MemberState;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Data
public class MemberRequestDto {
    @NotBlank(message = "Id는 필수 입력값 입니다.")
    @Size(min = 4, max=15, message = "Id를 4 ~ 15자 사이로 입력해주세요")
    private String memberId;

    @NotBlank(message = "Password는 필수 입력값 입니다.")
    @Size(max = 255)
    private String memberPassword;

    @Email(message = "email 형식을 지켜주세요.")
    private String memberEmail;

    private MemberGrade memberGrade;

    private MemberState memberState;
}

