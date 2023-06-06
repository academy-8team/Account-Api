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
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity<MemberResponseDto> getMember(@RequestParam(value = "username") String memberId) {
        return memberService.getMemberByMemberId(memberId)
                .map(member -> ResponseEntity.ok().body(member))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/member/exist")
    public ResponseEntity<MemberResponseDto> checkMemberHaveEmail(@RequestParam(value = "email") String email) {
        return memberService.findMemberHaveEmail(email)
                .map(member -> ResponseEntity.ok().body(member))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/member/register")
    public ResponseEntity<String> registerMember(@RequestBody @Valid MemberRequestDto memberRequestDto, BindingResult errors) {
        if (memberService.validCheck(errors)) {
            return ResponseEntity.badRequest().body(memberService.makeErrorMessage(errors));
        }

        return ResponseEntity.ok().body(memberService.register(memberRequestDto));
    }

    @GetMapping("/member/all")
    public List<MemberResponseDto> findAllMember() {
        return memberService.findAllMember();
    }
}