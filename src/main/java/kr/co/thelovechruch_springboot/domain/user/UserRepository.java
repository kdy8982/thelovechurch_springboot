package kr.co.thelovechruch_springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findById(String id); // 이미 생성된 사용자인지 판단하기 위한 메소드.

}
