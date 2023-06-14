package com.nhnacademy.account.controller;

import com.nhnacademy.account.dto.request.MemberRequestDto;
import com.nhnacademy.account.dto.respond.MemberRespondDto;
import com.nhnacademy.account.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<MemberRespondDto> getMember(@RequestParam(value = "username") String memberId) {
        Optional<MemberRespondDto> member = memberService.getMemberByMemberId(memberId);
        return member.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/exist")
    public ResponseEntity<MemberRespondDto> checkMemberHaveEmail(@RequestParam(value = "email") String email) {
        Optional<MemberRespondDto> member = memberService.findMemberHaveEmail(email);
        return member.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerMember(@RequestBody @Valid MemberRequestDto memberRequestDto, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(memberService.makeErrorMessage(errors));
        }
        String message = memberService.register(memberRequestDto);
        return ResponseEntity.ok().body(Collections.singletonMap("message", message));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MemberRespondDto>> findAllMember() {
        List<MemberRespondDto> members = memberService.findAllMember();
        return ResponseEntity.ok(members);
    }
}
