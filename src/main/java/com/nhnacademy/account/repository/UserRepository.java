/**
 * packageName :  com.nhnacademy.account.repository
 * fileName : UserRepository
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

package com.nhnacademy.account.repository;

import com.nhnacademy.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * @param email 사용자를 찾기 위한 메일
     * @return 찾아진 사용자에 대한 Optional객체. 사용자가 존재하지 않으면 null 값을 가진 Optional객체를 반환한다.
     */
    Optional<User> findByEmail(String email);
}