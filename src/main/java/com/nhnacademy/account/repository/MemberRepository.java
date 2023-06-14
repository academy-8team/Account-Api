package com.nhnacademy.account.repository;

import com.nhnacademy.account.dto.respond.MemberRespondDto;
import com.nhnacademy.account.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    MemberRespondDto findByMemberId(String memberId);

    MemberRespondDto findByMemberEmail(String email);

    List<MemberRespondDto> findAllBy();
}

