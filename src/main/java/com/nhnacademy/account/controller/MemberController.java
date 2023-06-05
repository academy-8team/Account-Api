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

port com.nhnacademy.account.dto.*;
import com.nhnacademy.account.dto.MemberCreateDto;
import com.nhnacademy.account.dto.MemberResponseDto;
import com.nhnacademy.account.dto.MemberUpdateDto;
import com.nhnacademy.account.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 회원 관리를 위한 컨트롤러 클래스입니다.
 * 이 클래스는 회원의 생성, 수정, 조회를 담당합니다.
 */
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    /**
     * 회원을 등록하는 메서드입니다.
     *
     * @param createDto 회원 정보를 담은 Dto 객체
     * @return 회원 정보를 담은 응답 Dto와 HTTP 상태 코드 CREATED를 반환합니다.
     */
    @PostMapping("/register")
    public ResponseEntity<MemberResponseDto> registerMember(@RequestBody MemberCreateDto createDto) {
        MemberResponseDto member = memberService.registerMember(createDto);
        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }

    /**
     * 회원의 상태를 변경하는 메서드입니다.
     *
     * @param memberId 상태를 변경할 회원의 식별자
     * @param updateDto 회원 상태 정보를 담은 Dto 객체
     * @return 변경 완료 후 HTTP 상태 코드 OK를 반환합니다.
     */
    @PutMapping("/{memberId}/status")
    public ResponseEntity<Void> updateMemberStatus(@PathVariable Long memberId, @RequestBody MemberUpdateDto updateDto) {
        memberService.updateMemberStatus(memberId, updateDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // change from OK to NO_CONTENT
    }


    /**
     * 회원을 조회하는 메서드입니다.
     *
     * @param memberId 조회할 회원의 식별자
     * @return 회원 정보를 담은 응답 Dto와 HTTP 상태 코드 OK를 반환합니다.
     */
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long memberId) {
        MemberResponseDto member = memberService.getMember(memberId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
im