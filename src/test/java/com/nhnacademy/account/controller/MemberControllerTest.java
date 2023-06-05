package com.nhnacademy.account.controller;

import com.nhnacademy.account.dto.MemberResponseDto;
import com.nhnacademy.account.entity.Member;
import com.nhnacademy.account.entity.MemberStatus;
import com.nhnacademy.account.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MemberControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void afterEach() {
        memberRepository.deleteAll();
    }

    @Test
    void registerMember_test() {
        // given
        MemberCreateDto createDto = new MemberCreateDto();
        createDto.setName("John");
        createDto.setEmail("john@example.com");
        createDto.setPassword("password123");

        String url = "http://localhost:" + port + "/members/register";

        // when
        ResponseEntity<MemberResponseDto> responseEntity = restTemplate.postForEntity(url, createDto, MemberResponseDto.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        MemberResponseDto createdMember = responseEntity.getBody();
        assertThat(createdMember).isNotNull();
        assertThat(createdMember.getName()).isEqualTo(createDto.getName());
        assertThat(createdMember.getEmail()).isEqualTo(createDto.getEmail());
    }

    @Test
    void getMember_test() {
        // given
        Member member = new Member();
        member.setName("John");
        member.setEmail("john@example.com");
        member.setPassword("password123");
        member.setMemberStatus(MemberStatus.ACTIVE);
        member = memberRepository.save(member);

        String url = "http://localhost:" + port + "/members/" + member.getId();

        // when
        ResponseEntity<MemberResponseDto> responseEntity = restTemplate.getForEntity(url, MemberResponseDto.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        MemberResponseDto fetchedMember = responseEntity.getBody();
        assertThat(fetchedMember).isNotNull();
        assertThat(fetchedMember.getId()).isEqualTo(member.getId());
        assertThat(fetchedMember.getName()).isEqualTo(member.getName());
        assertThat(fetchedMember.getEmail()).isEqualTo(member.getEmail());
    }

    @Test
    void updateMemberStatus_test() {
        // given
        Member member = new Member();
        member.setName("John");
        member.setEmail("john@example.com");
        member.setPassword("password123");
        member.setMemberStatus(MemberStatus.ACTIVE);
        member = memberRepository.save(member);

        MemberUpdateDto updateDto = new MemberUpdateDto();
        updateDto.setName("John Updated");
        updateDto.setEmail("john_updated@example.com");
        updateDto.setPassword("password123_updated");
        updateDto.setStatus(MemberStatus.INACTIVE.toString());

        String url = "http://localhost:" + port + "/members/" + member.getId() + "/status";

        // when
        HttpEntity<MemberUpdateDto> requestUpdate = new HttpEntity<>(updateDto);
        ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestUpdate, Void.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

        Optional<Member> memberOptional = memberRepository.findById(member.getId());
        assertThat(memberOptional).isPresent();

        Member updatedMember = memberOptional.get();
        assertThat(updatedMember.getName()).isEqualTo(updateDto.getName());
        assertThat(updatedMember.getEmail()).isEqualTo(updateDto.getEmail());
        assertThat(updatedMember.getMemberStatus().toString()).hasToString(updateDto.getStatus());
    }
}
