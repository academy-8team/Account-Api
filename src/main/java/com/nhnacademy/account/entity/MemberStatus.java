/**
 * packageName :  com.nhnacademy.account.entity
 * fileName : MemberStatus
 * author :  ichunghui
 * date : 2023/06/04 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/04                ichunghui             최초 생성
 */

package com.nhnacademy.account.entity;

public enum MemberStatus {
    MEMBER_MEMBERSHIP {
        @Override
        public String toString() {
            return "MEMBER_MEMBERSHIP";
        }
    }, MEMBER_WITHDRAW {
        @Override
        public String toString() {
            return "MEMBER_WITHDRAW";
        }
    }, MEMBER_DORMANT {
        @Override
        public String toString() {
            return "MEMBER_DORMANT";
        }
    }
}
