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
import com.nhnacademy.account.dto.MemberRespondDto;
import com.nhnacademy.account.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity<Optional<MemberRespondDto>> getMember(@RequestParam(value = "username") String memberId) {
        return new ResponseEntity<>(memberService.getMemberByMemberId(memberId), HttpStatus.OK);
    }

    @GetMapping("/member/exist")
    public ResponseEntity<Optional<MemberRespondDto>> checkMemberHaveEmail(@RequestParam(value = "email") String email) {
        return new ResponseEntity<>(memberService.findMemberHaveEmail(email), HttpStatus.OK);
    }

    @PostMapping("/member/register")
    public ResponseEntity<String> registerMember(@RequestBody @Valid MemberRequestDto memberRequestDto, BindingResult errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity<>(memberService.makeErrorMessage(errors), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(memberService.register(memberRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/member/all")
    public ResponseEntity<List<MemberRespondDto>> findAllMember() {
        return new ResponseEntity<>(memberService.findAllMember(), HttpStatus.OK);
    }
}
