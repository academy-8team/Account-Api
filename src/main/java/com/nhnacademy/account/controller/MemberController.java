/**
 * packageName :  com.nhnacademy.account.controller
 * fileName : MemberController
 * author :  ichunghui
 * date : 2023/06/04 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/04                ichunghui             최초 생성
 */

package com.nhnacademy.account.controller;

import com.nhnacademy.account.dto.MemberRequestDto;
import com.nhnacademy.account.dto.MemberResponseDto;
import com.nhnacademy.account.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member")
    public Optional<MemberResponseDto> getMember(@RequestParam(value = "username") String memberId) {
        return memberService.getMemberByMemberId(memberId);
    }

    @GetMapping("/member/exist")
    public Optional<MemberResponseDto> checkMemberHaveEmail(@RequestParam(value = "email") String email) {
        return memberService.findMemberHaveEmail(email);
    }

    @PostMapping("/member/register")
    public String registerMember(@RequestBody @Valid MemberRequestDto memberRequestDto, BindingResult errors) {
        if (memberService.validCheck(errors)) {
            return memberService.makeErrorMessage(errors);
        }

        return memberService.register(memberRequestDto);
    }

    @GetMapping("/member/all")
    public List<MemberResponseDto> findAllMember() {
        return memberService.findAllMember();
    }
}
