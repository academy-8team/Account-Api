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
import com.nhnacademy.account.entity.Member;
import com.nhnacademy.account.entity.MemberStatus;
import com.nhnacademy.account.mapper.MemberMapper;
import com.nhnacademy.account.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Transactional
    public MemberResponseDto registerMember(MemberCreateDto createDto) {
        Optional<Member> existingMember = memberRepository.findByEmail(createDto.getEmail());
        if (existingMember.isPresent()) {
            throw new RuntimeException("User already exists with email: " + createDto.getEmail());
        }
        Member member = memberMapper.toEntity(createDto);
        memberRepository.save(member);
        return memberMapper.toDto(member);
    }


    @Transactional
    public void updateMemberStatus(Long memberId, MemberUpdateDto updateDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + memberId));
        member.setName(updateDto.getName());
        member.setEmail(updateDto.getEmail());
        member.setPassword(updateDto.getPassword());
        member.setMemberStatus(MemberStatus.valueOf(updateDto.getStatus()));  // new status update
    }


    @Transactional(readOnly = true)
    public MemberResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return memberMapper.toDto(member);
    }
}

