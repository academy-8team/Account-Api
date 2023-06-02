/**
 * packageName :  com.nhnacademy.account.dto
 * fileName : UserResponseDto
 * author :  ichunghui
 * date : 2023/06/02
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */
package com.nhnacademy.account.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String status;
}