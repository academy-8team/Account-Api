/**
 * packageName :  com.nhnacademy.account.entity
 * fileName : MemberGrade
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.account.entity;

public enum MemberGrade {
    ROLE_ADMIN {
        @Override
        public String toString() {
            return "ROLE_ADMIN";
        }
    }
    , ROLE_USER {
        @Override
        public String toString() {
            return "ROLE_USER";
        }
    }
}
