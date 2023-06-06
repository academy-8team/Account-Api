/**
 * packageName :  com.nhnacademy.account.entity
 * fileName : Member
 * author :  ichunghui
 * date : 2023/06/04
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/04                ichunghui             최초 생성
 */

package com.nhnacademy.account.entity;

import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;
    private String memberId;
    private String memberPassword;
    private String memberEmail;
    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;
    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;
}
