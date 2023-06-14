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
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;

    @Size(min = 4, max = 15)
    @Length(min = 4, max = 15)
    @Column(name = "member_id")
    private String memberId;

    @Length(min = 4, max = 255)
    @Size(min = 4, max = 255)
    @Column(name = "member_password")
    private String memberPassword;

    @Email
    @Column(name = "member_email")
    private String memberEmail;

    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;

    @Enumerated(EnumType.STRING)
    private MemberState memberState;
}
