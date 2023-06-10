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
import com.nhnacademy.account.exception.InvalidInputException;
import com.nhnacademy.account.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    // 멤버 가입
    @PostMapping
    public ResponseEntity<String> registerMember(@RequestBody @Valid MemberRequestDto memberRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidInputException(bindingResult);
        }
        return ResponseEntity.ok().body(memberService.register(memberRequestDto));
    }


    // 멤버 목록 조회
    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> getAllMembers() {
        return ResponseEntity.ok().body(memberService.findAllMember());
    }

    // 멤버 상세 내용 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable String memberId) {
        return memberService.getMemberByMemberId(memberId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 멤버 정보 수정
    @PutMapping("/{memberId}")
    public ResponseEntity<String> updateMember(@PathVariable String memberId, @RequestBody @Valid MemberRequestDto memberRequestDto, BindingResult errors) {
        if (memberService.validCheck(errors)) {
            return ResponseEntity.badRequest().body(memberService.makeErrorMessage(errors));
        }
        return ResponseEntity.ok().body(memberService.updateMember(memberId, memberRequestDto));
    }

    // 멤버 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable String memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}