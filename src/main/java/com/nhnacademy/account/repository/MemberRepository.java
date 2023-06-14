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

import com.nhnacademy.account.dto.MemberRespondDto;
import com.nhnacademy.account.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {
    MemberRespondDto findByMemberId(String memberId);

    MemberRespondDto findByMemberEmail(String email);

    List<MemberRespondDto> findAllBy();
}

