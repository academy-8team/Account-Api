package com.nhnacademy.account.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.nhnacademy.account.dto.MemberRequestDto;
import com.nhnacademy.account.dto.MemberResponseDto;
import com.nhnacademy.account.entity.Member;
import com.nhnacademy.account.entity.MemberGrade;
import com.nhnacademy.account.entity.MemberState;
import com.nhnacademy.account.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    private Member member;
    private MemberRequestDto memberRequestDto;

    @BeforeEach
    void setUp() {
        member = Member.builder()
                .memberId("testId")
                .memberPassword("testPassword")
                .memberEmail("test@email.com")
                .memberGrade(MemberGrade.ROLE_USER)
                .memberState(MemberState.MEMBER_MEMBERSHIP)
                .build();

        memberRequestDto = new MemberRequestDto("testId", "testPassword", "test@email.com", MemberGrade.ROLE_USER, MemberState.MEMBER_MEMBERSHIP);
    }

    @Test
    void testGetMemberByMemberId() {
        when(memberRepository.findByMemberId("testId")).thenReturn(member);

        Optional<MemberResponseDto> result = memberService.getMemberByMemberId("testId");

        assertTrue(result.isPresent());
        assertEquals("testId", result.get().getMemberId());
    }

    @Test
    void testRegister() {
        when(memberRepository.save(any(Member.class))).thenReturn(member);

        String result = memberService.register(memberRequestDto);

        assertEquals("회원가입 되었습니다.", result);
    }

    @Test
    void testFindAllMember() {
        when(memberRepository.findAllBy()).thenReturn(Arrays.asList(member));

        List<MemberResponseDto> result = memberService.findAllMember();

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void testUpdateMember() {
        when(memberRepository.findByMemberId("testId")).thenReturn(member);

        String result = memberService.updateMember("testId", memberRequestDto);

        assertEquals("멤버 정보가 업데이트되었습니다.", result);
    }

    @Test
    void testDeleteMember() {
        doNothing().when(memberRepository).deleteByMemberId("testId");

        assertDoesNotThrow(() -> memberService.deleteMember("testId"));
    }

    @Test
    void testValidCheck() {
        BindingResult bindingResult = new BeanPropertyBindingResult(memberRequestDto, "memberRequestDto");

        assertFalse(memberService.validCheck(bindingResult));
    }

    @Test
    void testMakeErrorMessage() {
        BindingResult bindingResult = new BeanPropertyBindingResult(memberRequestDto, "memberRequestDto");

        String result = memberService.makeErrorMessage(bindingResult);

        assertTrue(result.isEmpty());
    }
}
