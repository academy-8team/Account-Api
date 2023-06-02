/**
 * packageName :  com.nhnacademy.account.entity
 * fileName : User
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.account.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "users_id", nullable = false)
    private Long id;

    @NotEmpty
    @Size(min=2, max=50)
    private String name;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
}