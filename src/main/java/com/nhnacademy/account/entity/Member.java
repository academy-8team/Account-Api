package com.nhnacademy.account.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;
    private String memberId;
    private String memberPassword;
    private String memberEmail;
    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;
    @Enumerated(EnumType.STRING)
    private MemberState memberState;
}
