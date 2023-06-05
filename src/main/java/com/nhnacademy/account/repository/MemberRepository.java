/**
 * packageName :  com.nhnacademy.account.repository
 * fileName : MemberRepository
 * author :  ichunghui
 * date : 2023/06/04 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/04                ichunghui             최초 생성
 */

package com.nhnacademy.account.repository;

import com.nhnacademy.account.dto.MemberResponseDto;
import com.nhnacademy.account.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    MemberResponseDto findByMemberId(String memberId);

    MemberResponseDto findByMemberEmail(String email);

    List<MemberResponseDto> findAllBy();
}

