package com.nhnacademy.account.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import com.nhnacademy.account.entity.Member;
import com.nhnacademy.account.entity.MemberGrade;
import com.nhnacademy.account.entity.MemberStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("application-dev")
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    private Member member;

    @BeforeEach
    void setUp() {
        member = Member.builder()
                .memberId("testId")
                .memberPassword("testPassword")
                .memberEmail("test@email.com")
                .memberGrade(MemberGrade.ROLE_USER)
                .memberStatus(MemberStatus.MEMBER_MEMBERSHIP)
                .build();

        memberRepository.save(member);
    }

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
    }

    @Test
    void testFindByMemberId() {
        Member result = memberRepository.findByMemberId("testId");

        assertNotNull(result);
        assertEquals("testId", result.getMemberId());
    }

    @Test
    void testFindByMemberEmail() {
        Member result = memberRepository.findByMemberEmail("test@email.com");

        assertNotNull(result);
        assertEquals("test@email.com", result.getMemberEmail());
    }

    @Test
    void testFindAllBy() {
        List<Member> result = memberRepository.findAllBy();

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void testDeleteByMemberId() {
        memberRepository.deleteByMemberId("testId");

        Optional<Member> result = Optional.ofNullable(memberRepository.findByMemberId("testId"));

        assertTrue(result.isEmpty());
    }
}
