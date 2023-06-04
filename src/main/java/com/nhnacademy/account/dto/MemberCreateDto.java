/**
 * packageName :  com.nhnacademy.account.dto
 * fileName : MemberCreateDto
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

@Data
public class MemberCreateDto {
    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;
}

