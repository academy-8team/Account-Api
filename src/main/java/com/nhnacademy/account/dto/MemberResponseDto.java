/**
 * packageName :  com.nhnacademy.account.dto
 * fileName : MemberResponseDto
 * author :  ichunghui
 * date : 2023/06/04 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/04                ichunghui             최초 생성
 */

package com.nhnacademy.account.dto;

import com.nhnacademy.account.entity.MemberGrade;
import com.nhnacademy.account.entity.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
public class MemberResponseDto {

    private Long memberNum;

    private String memberId;

    private String memberPassword;

    private String memberEmail;

    private MemberGrade memberGrade;

    private MemberStatus memberStatus;
}
