/**
 * packageName :  com.nhnacademy.account.mapper
 * fileName : UserMapper
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.account.mapper;

import com.nhnacademy.account.dto.UserCreateDto;
import com.nhnacademy.account.dto.UserResponseDto;
import com.nhnacademy.account.dto.UserUpdateDto;
import com.nhnacademy.account.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserCreateDto createDto) {
        User user = new User();
        user.setName(createDto.getName());
        user.setEmail(createDto.getEmail());
        user.setPassword(createDto.getPassword());
        return user;
    }

    public User toEntity(UserUpdateDto updateDto) {
        User user = new User();
        user.setName(updateDto.getName());
        user.setEmail(updateDto.getEmail());
        user.setPassword(updateDto.getPassword());
        return user;
    }

    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setStatus(user.getUserStatus().toString());
        return dto;
    }
}

