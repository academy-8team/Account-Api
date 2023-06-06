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
import com.nhnacademy.account.entity.MemberStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Data
public class MemberRequestDto {

    @NotBlank(message = "ID를 입력하세요")
    private String memberId;

    @NotBlank(message = "Password를 입력하세요")
    private String memberPassword;

    @Email(message = "email 형식을 지켜주세요.")
    private String memberEmail;

    private MemberGrade memberGrade;

    private MemberStatus memberStatus;
}


