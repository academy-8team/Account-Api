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

import com.nhnacademy.account.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberId(String memberId);
    Member findByMemberEmail(String email);
    List<Member> findAllBy();
}
// 마르코님한테  질문, Dto의 사용범위는 어디까지인가? Controller와 Service의 사이에서만 사용해야하는가