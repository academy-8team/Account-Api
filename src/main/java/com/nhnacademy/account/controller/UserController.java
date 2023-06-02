/**
 * packageName :  com.nhnacademy.account.controller
 * fileName : UserController
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.account.controller;

import com.nhnacademy.account.dto.UserCreateDto;
import com.nhnacademy.account.dto.UserResponseDto;
import com.nhnacademy.account.dto.UserUpdateDto;
import com.nhnacademy.account.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserCreateDto createDto) {
        UserResponseDto user = userService.registerUser(createDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}/status")
    public ResponseEntity<Void> updateUserStatus(@PathVariable Long userId, @RequestBody UserUpdateDto updateDto) {
        userService.updateUserStatus(userId, updateDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long userId) {
        UserResponseDto user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}