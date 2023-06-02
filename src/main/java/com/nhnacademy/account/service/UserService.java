/**
 * packageName :  com.nhnacademy.account.service
 * fileName : UserService
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.account.service;

import com.nhnacademy.account.dto.UserCreateDto;
import com.nhnacademy.account.dto.UserResponseDto;
import com.nhnacademy.account.dto.UserUpdateDto;
import com.nhnacademy.account.entity.User;
import com.nhnacademy.account.mapper.UserMapper;
import com.nhnacademy.account.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserResponseDto registerUser(UserCreateDto createDto) {
        User user = userMapper.toEntity(createDto);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Transactional
    public void updateUserStatus(Long userId, UserUpdateDto updateDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(updateDto.getName());
        user.setEmail(updateDto.getEmail());
        user.setPassword(updateDto.getPassword());
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }
}