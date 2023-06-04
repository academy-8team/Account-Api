/**
 * packageName :  com.nhnacademy.account.mapper
 * fileName : MemberMapper
 * author :  ichunghui
 * date : 2023/06/04 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/04                ichunghui             최초 생성
 */

package com.nhnacademy.account.mapper;

import com.nhnacademy.account.dto.*;
import com.nhnacademy.account.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member toEntity(MemberCreateDto createDto) {
        Member member = new Member();
        member.setName(createDto.getName());
        member.setEmail(createDto.getEmail());
        member.setPassword(createDto.getPassword());
        return member;
    }

    public Member toEntity(MemberUpdateDto updateDto) {
        Member member = new Member();
        member.setName(updateDto.getName());
        member.setEmail(updateDto.getEmail());
        member.setPassword(updateDto.getPassword());
        return member;
    }

    public MemberResponseDto toDto(Member member) {
        MemberResponseDto dto = new MemberResponseDto();
        dto.setId(member.getId());
        dto.setName(member.getName());
        dto.setEmail(member.getEmail());

        if(member.getMemberStatus() != null) {
            dto.setStatus(member.getMemberStatus().toString());
        } else {
            dto.setStatus(null);
        }

        return dto;
    }
}

