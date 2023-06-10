package com.nhnacademy.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.account.dto.MemberRequestDto;
import com.nhnacademy.account.dto.MemberResponseDto;
import com.nhnacademy.account.entity.MemberGrade;
import com.nhnacademy.account.entity.MemberStatus;
import com.nhnacademy.account.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MemberService memberService;

    private MemberRequestDto memberRequestDto;

    @BeforeEach
    void setUp() {
        memberRequestDto = new MemberRequestDto();
        memberRequestDto.setMemberId("testId");
        memberRequestDto.setMemberPassword("testPassword");
        memberRequestDto.setMemberEmail("test@email.com");
        memberRequestDto.setMemberGrade(MemberGrade.ROLE_USER);
        memberRequestDto.setMemberStatus(MemberStatus.MEMBER_MEMBERSHIP);
    }

    @Test
    void testRegisterMember() throws Exception {
        when(memberService.register(any(MemberRequestDto.class))).thenReturn("회원가입 되었습니다.");

        mockMvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(memberRequestDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("회원가입 되었습니다."));
    }

    @Test
    void testGetAllMembers() throws Exception {
        MemberResponseDto responseDto = MemberResponseDto.builder()
                .memberId("testId")
                .memberEmail("test@email.com")
                .memberGrade(MemberGrade.ROLE_USER)
                .memberStatus(MemberStatus.MEMBER_MEMBERSHIP)
                .build();

        when(memberService.findAllMember()).thenReturn(Collections.singletonList(responseDto));

        mockMvc.perform(get("/members"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(responseDto))));
    }

    @Test
    void testGetMember() throws Exception {
        MemberResponseDto responseDto = MemberResponseDto.builder()
                .memberId("testId")
                .memberEmail("test@email.com")
                .memberGrade(MemberGrade.ROLE_USER)
                .memberStatus(MemberStatus.MEMBER_MEMBERSHIP)
                .build();

        when(memberService.getMemberByMemberId("testId")).thenReturn(java.util.Optional.of(responseDto));

        mockMvc.perform(get("/members/testId"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(responseDto)));
    }

    @Test
    void testUpdateMember() throws Exception {
        when(memberService.updateMember(any(String.class), any(MemberRequestDto.class))).thenReturn("멤버 정보가 업데이트되었습니다.");

        mockMvc.perform(put("/members/testId")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(memberRequestDto)))
                .andExpect(status().isOk())
                .andExpect(content().string("멤버 정보가 업데이트되었습니다."));
    }

    @Test
    void testDeleteMember() throws Exception {
        doNothing().when(memberService).deleteMember(any(String.class));

        mockMvc.perform(delete("/members/testId"))
                .andExpect(status().isNoContent());
    }
}
