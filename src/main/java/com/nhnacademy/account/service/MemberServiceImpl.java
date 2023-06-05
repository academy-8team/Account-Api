/**
 * packageName :  com.nhnacademy.account.service
 * fileName : MemberServiceImpl
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.account.service;

import com.nhnacademy.account.dto.MemberRequestDto;
import com.nhnacademy.account.dto.MemberResponseDto;
import com.nhnacademy.account.entity.Member;
import com.nhnacademy.account.entity.MemberGrade;
import com.nhnacademy.account.entity.MemberStatus;
import com.nhnacademy.account.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Optional<MemberResponseDto> getMemberByMemberId(String memberId) {
        return Optional.ofNullable(memberRepository.findByMemberId(memberId));
    }

    @Override
    public Optional<MemberResponseDto> findMemberHaveEmail(String email) {
        return Optional.ofNullable(memberRepository.findByMemberEmail(email));
    }

    @Override
    public String register(MemberRequestDto memberRequestDto) {
        Member member = Member.builder()
                .memberId(memberRequestDto.getMemberId())
                .memberPassword(memberRequestDto.getMemberPassword())
                .memberEmail(memberRequestDto.getMemberEmail())
                .memberGrade(MemberGrade.ROLE_USER)
                .memberStatus(MemberStatus.MEMBER_MEMBERSHIP)
                .build();

        memberRepository.save(member);

        return "회원가입 되었습니다.";
    }

    @Override
    public boolean validCheck(BindingResult errors) {
        return errors.hasErrors();
    }

    @Override
    public String makeErrorMessage(BindingResult errors) {
        Map<String, String> validatorResult = validateHandling(errors);
        return validatorResult.keySet().stream().findFirst().map(validatorResult::get).orElse("");

    }

    @Override
    public List<MemberResponseDto> findAllMember() {
        return memberRepository.findAllBy();
    }

    private Map<String, String> validateHandling(BindingResult errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }
}
