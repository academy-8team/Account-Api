/**
 * packageName :  com.nhnacademy.account.service
 * fileName : MemberService
 * author :  ichunghui
 * date : 2023/06/04
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/04                ichunghui             최초 생성
 */

package com.nhnacademy.account.service;

import com.nhnacademy.account.dto.*;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Optional<MemberResponseDto> getMemberByMemberId(String memberId);

    Optional<MemberResponseDto> findMemberHaveEmail(String email);

    List<MemberResponseDto> findAllMember();

    String register(MemberRequestDto memberRequestDto);

    boolean validCheck(BindingResult errors);

    String makeErrorMessage(BindingResult errors);

}