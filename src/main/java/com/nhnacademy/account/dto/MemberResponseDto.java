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
    private MemberState memberState;
}
