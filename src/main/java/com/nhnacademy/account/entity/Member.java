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
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "members")
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_num")
    private Long memberNum;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "member_email")
    private String memberEmail;

    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;
    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    public void updateMemberInfo(String memberId, String memberPassword, String memberEmail, MemberGrade memberGrade, MemberStatus memberStatus) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberEmail = memberEmail;
        this.memberGrade = memberGrade;
        this.memberStatus = memberStatus;
    }
}
